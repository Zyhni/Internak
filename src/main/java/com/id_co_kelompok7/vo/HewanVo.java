package com.id_co_kelompok7.vo;

import com.id_co_kelompok7.model.Hewan;
import com.id_co_kelompok7.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HewanVo {

    private Integer hwnId;

    private Integer kdgId;

    private String hwnNama;

    private Integer hwnUsia;

    private Integer hwnBerat;

    private String hwnMasuk;

    private String hwnStatus;

    public HewanVo(Hewan hewan){
        this.hwnId = hewan.getHwnId();
        this.kdgId = hewan.getKdgId();
        this.hwnNama = hewan.getHwnNama();
        this.hwnUsia = hewan.getHwnUsia();
        this.hwnBerat = hewan.getHwnBerat();
        this.hwnMasuk = hewan.getHwnMasuk();
        this.hwnStatus = hewan.getHwnStatus();
    }
}
