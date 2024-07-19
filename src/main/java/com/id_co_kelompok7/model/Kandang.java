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
@Table(name = "ms_kandang")
public class Kandang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kdg_id")
    private Integer kdgId;

    @Column(name = "usr_id")
    private Integer usrId;

    @Column(name = "kdg_nama")
    private String kdgNama;

    @Column(name = "kdg_jenis")
    private String kdgJenis;

    @Column(name = "kdg_kapasitas")
    private Integer kdgKapasitas;

    @Column(name = "kdg_luas")
    private Integer kdgLuas;

    @Column(name = "kdg_alamat")
    private String kdgAlamat;

    @Column(name = "kdg_suhu")
    private Integer kdgSuhu;

    @Column(name = "kdg_status_monitor")
    private String kdgStatusMonitor;

    @Column(name = "kdg_status")
    private String kdgStatus;

    @Column(name = "kdg_lattitude")
    private double kdgLattitude;

    @Column(name = "kdg_longtitude")
    private double kdgLongtitude;
}
