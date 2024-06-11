package com.id_co_kelompok7.vo;

import com.id_co_kelompok7.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {

    private Integer usrId;

    private String usrNamaDepan;

    private String usrNamaBlkg;

    private String kodePos;

    private String noTelp;

    private String usrEmail;

    private String usrNama;

    private String usrPassword;

    private String usrStatus;

    public LoginVo(User user){
        this.usrId = user.getUsrId();
        this.usrNamaDepan = user.getUsrNamaDepan();
        this.usrNamaBlkg = user.getUsrNamaBlkg();
        this.kodePos = user.getKodePos();
        this.noTelp = user.getNoTelp();
        this.usrEmail = user.getUsrEmail();
        this.usrNama = user.getUsrNama();
        this.usrPassword = user.getUsrPassword();
        this.usrStatus = user.getUsrStatus();
    }
}
