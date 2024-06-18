package com.id_co_kelompok7.vo;

import com.id_co_kelompok7.model.Monitoring;
import com.id_co_kelompok7.model.Notifikasi;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MonitoringVo {
    private Integer tmoId;

    private Integer hwnId;

    private String tmoKeluhan;

    private String tmoDeskripsi;

    private String tmoPeriode;

    private LocalDate tmoTanggalMulai;

    private LocalDate tmoTanggalAkhir;

    private String tmoStatus;

    public MonitoringVo(Monitoring monitoring) {
        this.tmoId = monitoring.getTmoId();
        this.hwnId = monitoring.getHwnId();
        this.tmoKeluhan = monitoring.getTmoKeluhan();
        this.tmoDeskripsi = monitoring.getTmoDeskripsi();
        this.tmoPeriode = monitoring.getTmoPeriode();
        this.tmoTanggalMulai = monitoring.getTmoTanggalMulai();
        this.tmoTanggalAkhir = monitoring.getTmoTanggalAkhir();
        this.tmoStatus = monitoring.getTmoStatus();
    }

}
