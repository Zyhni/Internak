package com.id_co_kelompok7.service;

import com.id_co_kelompok7.model.Kandang;
import com.id_co_kelompok7.model.User;
import com.id_co_kelompok7.repository.KandangRepository;
import com.id_co_kelompok7.repository.UserRepository;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.vo.KandangVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KandangService {

    @Autowired
    private KandangRepository kandangRepository;

    @Autowired
    private UserRepository userRepository;

    public DtoResponse saveKandang(Kandang kandang){
        try {
            User existingUser = userRepository.findById(kandang.getUsrId()).orElse(null);

            if(existingUser != null){
                Kandang data = new Kandang();
                BeanUtils.copyProperties(kandang, data);
                data.setKdgStatus("Aktif");
                kandangRepository.save(data);
                return new DtoResponse(200, kandang, "Sukses Membuat Data");
            }else {
                return new DtoResponse(404, null, "Kandang Tidak di temukan");
            }

        }catch (Exception e){
            return new DtoResponse(500, null,"Terjadi saat menambahkan data " + e.getMessage());
        }

    }

    public DtoResponse getAllKandangByStatusAndIdUser(Integer idUser){
        User userDB = userRepository.findById(idUser).orElse(null);

        if(userDB != null){
            String status = "Aktif";
            Iterable<Kandang> kandangs = kandangRepository.getKandangByIdUser(idUser, status);
            List<KandangVo> kandangVos = new ArrayList<>();

            for (Kandang item: kandangs){
                KandangVo kandangVo = new KandangVo(item);
                kandangVo.setKdgStatus(kandangVo.getKdgStatus() == null ? "" : kandangVo.getKdgStatus());
                kandangVos.add(kandangVo);
            }
            return new DtoResponse(200, kandangVos, "Data Di temukan");
        }else if(userDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }

    }

    public DtoResponse updateKandang(Kandang kandang){
        try {
            Kandang existingKandang = kandangRepository.findById(kandang.getKdgId()).orElse(null);

            if (existingKandang != null) {
                BeanUtils.copyProperties(kandang, existingKandang, "kdgId", "usrId");
                kandangRepository.save(existingKandang);
                return new DtoResponse(200, existingKandang, "Sukses Memperbarui Data");
            } else {
                return new DtoResponse(404, null, "Data Kandang tidak di temukan");
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat memperbarui data " + e.getMessage());
        }
    }

    public DtoResponse deleteKandang(Integer idKandang){
        try {
            Kandang kandangDB = kandangRepository.findById(idKandang).orElse(null);
            Kandang deleteKandang = new Kandang();
            BeanUtils.copyProperties(kandangDB, deleteKandang);
            deleteKandang.setKdgStatus("Tidak Aktif");
            kandangRepository.save(deleteKandang);
            return new DtoResponse(200, deleteKandang, "Suskses Menghapus Data Kandang");
        }catch (Exception e){
            return new DtoResponse(500, null, "Terjadi Kesalahan dalam menghapus data " + e.getMessage());
        }
    }
}
