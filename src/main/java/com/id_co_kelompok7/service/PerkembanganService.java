package com.id_co_kelompok7.service;

import com.id_co_kelompok7.model.*;
import com.id_co_kelompok7.repository.HewanRepository;
import com.id_co_kelompok7.repository.MonitoringRepository;
import com.id_co_kelompok7.repository.PerkembanganRepository;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.vo.KodePosVo;
import com.id_co_kelompok7.vo.PerkembanganVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PerkembanganService {
    @Autowired
    MonitoringRepository monitoringRepository;

    @Autowired
    PerkembanganRepository perkembanganRepository;

    public DtoResponse savePerkembangan(Perkembangan perkembangan) {
        try {
            Monitoring existingMonitoring = monitoringRepository.findById(perkembangan.getTmoId()).orElse(null);

            if (existingMonitoring != null) {
                Perkembangan data = new Perkembangan();
                BeanUtils.copyProperties(perkembangan, data);
                data.setDtpTimestamp(LocalDateTime.now());
                perkembanganRepository.save(data);
                return new DtoResponse(200, existingMonitoring, "Sukses Memperbarui Data");
            } else {
                return new DtoResponse(404, null, "Data Monitoring tidak di temukan");
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat memperbarui data " + e.getMessage());
        }
    }
    public DtoResponse getAllPerkembangan(){
        Iterable<Perkembangan> perkembangans = perkembanganRepository.findAll();
        List<PerkembanganVo> perkembanganVos = new ArrayList<>();

        for (Perkembangan item: perkembangans){
            PerkembanganVo perkembanganVo = new PerkembanganVo(item);
            perkembanganVos.add(perkembanganVo);
        }
        return new DtoResponse(200, perkembanganVos, "Data Di temukan");
    }
    public DtoResponse getPerkembanganById(Integer idPerkembangan){
        Iterable<Perkembangan> perkembangans = perkembanganRepository.getPerkembanganById(idPerkembangan);
        List<PerkembanganVo> perkembanganVos = new ArrayList<>();
        if(perkembangans != null){
            for (Perkembangan item: perkembangans){
                PerkembanganVo perkembanganVo = new PerkembanganVo(item);
                perkembanganVos.add(perkembanganVo);
            }
            return new DtoResponse(200, perkembanganVos, "Sukses");
        }else {
            return new DtoResponse(404, null, "Data Layanan tidak di temukan");
        }

    }
}
