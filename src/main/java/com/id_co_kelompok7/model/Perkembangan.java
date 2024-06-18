package com.id_co_kelompok7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dtp_perkembangan")
public class Perkembangan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dtp_id")
    private Integer dtpId;

    @Column(name = "tmo_id")
    private Integer tmoId;

    @Column(name = "dtp_deskripsi")
    private String dtpDeskripsi;

    @Column(name = "dtp_file")
    private String dtpFile;

    @Column(name = "dtp_timestamp")
    private LocalDateTime dtpTimestamp;

}
