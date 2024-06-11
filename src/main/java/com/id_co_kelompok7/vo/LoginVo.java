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

    private String usrNama;

    private String noTelp;

    private String usrEmail;

    private String usrStatus;

    public LoginVo(User user){
        this.usrId = user.getUsrId();
        this.usrNama = user.getUsrNama();
        this.noTelp = user.getNoTelp();
        this.usrEmail = user.getUsrEmail();
        this.usrStatus = user.getUsrStatus();
    }
}
