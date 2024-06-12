// NotifikasiVo.java
package com.id_co_kelompok7.vo;

import com.id_co_kelompok7.model.Notifikasi;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class NotifikasiVo {
    private Integer ntfId;

    private Integer kdgId;

    private String ntfJudul;

    private String ntfDeskripsi;

    private String ntfTipe;

    private String ntfStatus;

    private LocalDateTime ntfTimestamp;

    public NotifikasiVo(Notifikasi notifikasi) {
        this.ntfId = notifikasi.getNtfId();
        this.kdgId = notifikasi.getKdgId();
        this.ntfJudul = notifikasi.getNtfJudul();
        this.ntfDeskripsi = notifikasi.getNtfDeskripsi();
        this.ntfTipe = notifikasi.getNtfTipe();
        this.ntfStatus = notifikasi.getNtfStatus();
        this.ntfTimestamp = notifikasi.getNtfTimestamp();
    }
}
