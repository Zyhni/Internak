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
@Table(name = "ms_hewan")
public class Hewan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hwn_id")
    private Integer hwnId;

    @Column(name = "kdg_id")
    private Integer kdgId;

    @Column(name = "hwn_nama")
    private String hwnNama;

    @Column(name = "hwn_usia")
    private Integer hwnUsia;

    @Column(name = "hwn_berat")
    private Integer hwnBerat;

    @Column(name = "hwn_masuk")
    private String hwnMasuk;

    @Column(name = "hwn_status")
    private String hwnStatus;
}
