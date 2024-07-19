package com.id_co_kelompok7.vo;

import com.id_co_kelompok7.model.Hewan;
import com.id_co_kelompok7.model.Kandang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KandangVo {

    private Integer kdgId;

    private Integer usrId;

    private String kdgNama;

    private String kdgJenis;

    private Integer kdgKapasitas;

    private Integer kdgLuas;

    private String kdgAlamat;

    private double kdgLattitude;
    
    private double kdgLongtitude;

    private Integer kdgSuhu;

    private String kdgStatusMonitor;

    private String kdgStatus;

    public KandangVo(Kandang kandang){
        this.kdgId = kandang.getKdgId();
        this.usrId = kandang.getUsrId();
        this.kdgNama = kandang.getKdgNama();
        this.kdgJenis = kandang.getKdgJenis();
        this.kdgKapasitas = kandang.getKdgKapasitas();
        this.kdgLuas = kandang.getKdgLuas();
        this.kdgAlamat = kandang.getKdgAlamat();
        this.kdgLattitude = kandang.getKdgLattitude();
        this.kdgLongtitude = kandang.getKdgLongtitude();
        this.kdgSuhu = kandang.getKdgSuhu();
        this.kdgStatusMonitor = kandang.getKdgStatusMonitor();
        this.kdgStatus = kandang.getKdgStatus();
    }
}
