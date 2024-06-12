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
@Table(name = "ms_kodepos")
public class KodePos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kpo_id")
    private Integer kpoId;

    @Column(name = "kpo_kodepos")
    private String kpoKodePos;

    @Column(name = "kpo_kelurahan")
    private String kpoKelurahan;

    @Column(name = "kpo_kecamatan")
    private String kpoKecamatan;

    @Column(name = "kpo_kabupaten")
    private String kpoKabupaten;

    @Column(name = "kpo_provinsi")
    private String kpoProvinsi;

    @Column(name = "kpo_status")
    private String kpoStatus;
}
