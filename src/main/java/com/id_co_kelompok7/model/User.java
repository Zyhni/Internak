package com.id_co_kelompok7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ms_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Integer usrId;

    @Column(name = "usr_nama_depan")
    private String usrNamaDepan;

    @Column(name = "usr_nama_blkg")
    private String usrNamaBlkg;

    @Column(name = "kpo_id")
    private String kodePos;

    @Column(name = "usr_telp")
    private String noTelp;

    @Column(name = "usr_email")
    private String usrEmail;

    @Column(name = "usr_username")
    private String usrNama;

    @Column(name = "usr_password")
    private String usrPassword;

    @Column(name = "usr_status")
    private String usrStatus;
}
