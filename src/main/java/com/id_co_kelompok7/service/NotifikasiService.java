package com.id_co_kelompok7.service;

import com.id_co_kelompok7.model.Kandang;
import com.id_co_kelompok7.model.Notifikasi;
import com.id_co_kelompok7.repository.KandangRepository;
import com.id_co_kelompok7.repository.NotifikasiRepository;
import com.id_co_kelompok7.vo.NotifikasiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotifikasiService {

    @Autowired
    NotifikasiRepository notifikasiRepository;

    @Autowired
    KandangRepository kandangRepository;

    public void cekDanBuatNotifikasi() {
        List<Kandang> kandangs = kandangRepository.findAll();

        for (Kandang kandang : kandangs) {
            if (kandang.getKdgSuhu() > 25) {
                Notifikasi notifikasi = new Notifikasi();
                notifikasi.setKdgId(kandang.getKdgId());
                notifikasi.setNtfJudul("Waspada, Temperatur Tinggi");
                notifikasi.setNtfDeskripsi("Terjadi kenaikan suhu pada kandang " + kandang.getKdgNama());
                notifikasi.setNtfTipe("Suhu");
                notifikasi.setNtfStatus("Bahaya");
                notifikasi.setNtfTimestamp(LocalDateTime.now());

                notifikasiRepository.save(notifikasi);
            }
        }
    }

    public List<NotifikasiVo> getAllNotifikasi() {
        List<Notifikasi> notifikasis = notifikasiRepository.findAll();
        List<NotifikasiVo> notifikasiVos = new ArrayList<>();

        for (Notifikasi notifikasi : notifikasis) {
            notifikasiVos.add(new NotifikasiVo(notifikasi));
        }

        return notifikasiVos;
    }
}
