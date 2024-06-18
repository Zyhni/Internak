package com.id_co_kelompok7.vo;

import com.id_co_kelompok7.model.Monitoring;
import com.id_co_kelompok7.model.Perkembangan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PerkembanganVo {
    private Integer dtpId;
    private Integer tmoId;
    private String dtpDeskripsi;
    private String dtpFile;
    private LocalDateTime dtpTimestamp;

    public PerkembanganVo(Perkembangan perkembangan) {
        this.dtpId = perkembangan.getDtpId();
        this.tmoId = perkembangan.getTmoId();
        this.dtpDeskripsi = perkembangan.getDtpDeskripsi();
        this.dtpFile = perkembangan.getDtpFile();
        this.dtpTimestamp = perkembangan.getDtpTimestamp();
    }

}
