package com.id_co_kelompok7.service;

import com.id_co_kelompok7.repository.UserRepository;
import com.id_co_kelompok7.model.User;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.vo.LoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public DtoResponse registerUser(User user){
        try {
            String existingEmail = checkEmail(user.getUsrEmail());
            if(user.getUsrEmail().equals(existingEmail)){
                return new DtoResponse(409, existingEmail, "Email Sudah di Gunakan");
            } else {
                User newData = new User();
                newData.setUsrNamaDepan(user.getUsrNamaDepan());
                newData.setUsrNamaBlkg(user.getUsrNamaBlkg());
                newData.setKodePos(user.getKodePos());
                newData.setNoTelp(user.getNoTelp());
                newData.setUsrEmail(user.getUsrEmail());
                newData.setUsrNama(user.getUsrNama());
                newData.setUsrPassword(user.getUsrPassword());
                newData.setUsrStatus("Aktif");
                userRepository.save(newData);
                return new DtoResponse(200,user,"Sukses Membuat Data");
            }
        }catch (Exception e){
            return new DtoResponse(500,user,"Terjadi Kesalahan saat menambah data " + e.getMessage());
        }
    }

    public DtoResponse getUserByEmailAndPassword(String email, String password){
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if(user != null){
            LoginVo loginVo = new LoginVo(user);
            return new DtoResponse(200, loginVo, "Sukses");
        }else {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }
    }

    public String checkEmail(String submittedEmail){
        return userRepository.getExistingEmail(submittedEmail);
    }


    // Method untuk membuat string acak
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public DtoResponse resetPasswordByEmail(String email){

        //Generate Temp Password
        String temporaryPassword = generateRandomString(12);

        User userDB = userRepository.findUserByEmail(email);
        User user = new User();

        //Copy semua property dari userDB
        BeanUtils.copyProperties(userDB, user);
        user.setUsrPassword(temporaryPassword);

        //Mengupdate data password baru
        userRepository.save(user);

        createEmail(email, "Reset Password", "Password sementara Anda adalah: " + temporaryPassword);
        return new DtoResponse(200, email, "Password baru sudah dikirim ke email Anda");
    }

    public DtoResponse resetPasswordByTempPassword(String oldPassword, String newPassword){
        User userDB = userRepository.findUserByPassword(oldPassword);

        if(userDB == null ){
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDB, user);
            user.setUsrPassword(newPassword);
            userRepository.save(user);
            return new DtoResponse(200,null ,"Sukses mengubah password anda");
        }

    }

    public void createEmail(String toEmail,
                            String subject,
                            String body){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("faizzihnia@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
    }

}
