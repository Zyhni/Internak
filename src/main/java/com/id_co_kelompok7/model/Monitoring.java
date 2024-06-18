package com.id_co_kelompok7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tr_monitoring")
public class Monitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tmo_id")
    private Integer tmoId;

    @Column(name = "hwn_id")
    private Integer hwnId;

    @Column(name = "tmo_keluhan")
    private String tmoKeluhan;

    @Column(name = "tmo_deskripsi")
    private String tmoDeskripsi;

    @Column(name = "tmo_periode")
    private String tmoPeriode;

    @Column(name = "tmo_tanggalmulai")
    private LocalDate tmoTanggalMulai;

    @Column(name = "tmo_tanggalakhir")
    private LocalDate tmoTanggalAkhir;

    @Column(name = "tmo_status")
    private String tmoStatus;
}
