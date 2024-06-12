package com.id_co_kelompok7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tr_notifikasi")
public class Notifikasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ntf_id")
    private Integer ntfId;

    @Column(name = "kdg_id")
    private Integer kdgId;

    @Column(name = "ntf_judul")
    private String ntfJudul;

    @Column(name = "ntf_deskripsi")
    private String ntfDeskripsi;

    @Column(name = "ntf_tipe")
    private String ntfTipe;

    @Column(name = "ntf_status")
    private String ntfStatus;

    @Column(name = "ntf_timestamp")
    private LocalDateTime ntfTimestamp;
}
