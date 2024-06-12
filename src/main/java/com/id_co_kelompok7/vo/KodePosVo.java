package com.id_co_kelompok7.vo;

import com.id_co_kelompok7.model.Kandang;
import com.id_co_kelompok7.model.KodePos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KodePosVo {

    private Integer kpoId;

    private String kpoKodePos;

    private String kpoKelurahan;

    private String kpoKecamatan;

    private String kpoKabupaten;

    private String kpoProvinsi;

    private String kpoStatus;

    public KodePosVo(KodePos kodePos){
        this.kpoId = kodePos.getKpoId();
        this.kpoKodePos = kodePos.getKpoKodePos();
        this.kpoKelurahan = kodePos.getKpoKelurahan();
        this.kpoKecamatan = kodePos.getKpoKecamatan();
        this.kpoKabupaten = kodePos.getKpoKabupaten();
        this.kpoProvinsi = kodePos.getKpoProvinsi();
        this.kpoStatus = kodePos.getKpoStatus();

    }
}
