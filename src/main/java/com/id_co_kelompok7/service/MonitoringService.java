package com.id_co_kelompok7.service;

import com.id_co_kelompok7.model.Hewan;
import com.id_co_kelompok7.model.Monitoring;
import com.id_co_kelompok7.model.Perkembangan;
import com.id_co_kelompok7.repository.HewanRepository;
import com.id_co_kelompok7.repository.MonitoringRepository;
import com.id_co_kelompok7.repository.PerkembanganRepository;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.vo.MonitoringVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonitoringService {
    @Autowired
    MonitoringRepository monitoringRepository;

    @Autowired
    HewanRepository hewanRepository;


    public DtoResponse saveMonitoring(Monitoring monitoring) {
        try {
            Hewan existingHewan = hewanRepository.findById(monitoring.getHwnId()).orElse(null);

            if (existingHewan != null) {
                Monitoring data = new Monitoring();
                BeanUtils.copyProperties(monitoring, data);
                data.setTmoTanggalMulai(LocalDate.now());

                LocalDate tmoTanggalMulai = data.getTmoTanggalMulai();
                if ("Harian".equals(data.getTmoPeriode())) {
                    data.setTmoTanggalAkhir(tmoTanggalMulai.plusDays(1));
                } else if ("Mingguan".equals(data.getTmoPeriode())) {
                    data.setTmoTanggalAkhir(tmoTanggalMulai.plusWeeks(1));
                } else {
                    data.setTmoTanggalAkhir(tmoTanggalMulai.plusMonths(1));
                }
                data.setTmoStatus("Proses");
                monitoringRepository.save(data);

                return new DtoResponse(200, monitoring, "Sukses Membuat Data");
            } else {
                return new DtoResponse(404, null, "Monitoring Tidak di temukan");
            }

        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi saat menambahkan data " + e.getMessage());
        }

    }

    public DtoResponse getAllMonitoringByStatusAndIdHewan(Integer idHewan) {
        Hewan hewanDB = hewanRepository.findById(idHewan).orElse(null);

        if (hewanDB != null) {
            String status = "Proses";
            Iterable<Monitoring> monitorings = monitoringRepository.getMonitoringByIdHewan(idHewan, status);
            List<MonitoringVo> monitoringVos = new ArrayList<>();

            for (Monitoring item : monitorings) {
                MonitoringVo monitoringVo = new MonitoringVo(item);
                monitoringVo.setTmoStatus(monitoringVo.getTmoStatus() == null ? "" : monitoringVo.getTmoStatus());
                monitoringVos.add(monitoringVo);
            }
            return new DtoResponse(200, monitoringVos, "Data Di temukan");
        } else if (hewanDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        } else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }

    }
    public DtoResponse getAllMonitoring(){
        Iterable<Monitoring> monitorings = monitoringRepository.findAll();
        List<MonitoringVo> monitoringVos = new ArrayList<>();
        for (Monitoring item: monitorings){
            MonitoringVo monitoringVo = new MonitoringVo(item);
            monitoringVos.add(monitoringVo);
        }
        return new DtoResponse(200, monitoringVos, "Data Di temukan");
    }

    public DtoResponse updateMonitoringStatus(Monitoring monitoring) {
        try {
            Monitoring existingMonitoring = monitoringRepository.findById(monitoring.getTmoId()).orElse(null);

            if (existingMonitoring != null) {
                BeanUtils.copyProperties(monitoring, existingMonitoring, "tmoId", "hwnId", "tmoKeluhan", "tmoDeskripsi", "tmoPeriode", "tmoTanggalMulai", "tmoTanggalAkhir");
                existingMonitoring.setTmoStatus("Selesai");
                monitoringRepository.save(existingMonitoring);
                return new DtoResponse(200, existingMonitoring, "Sukses Memperbarui Data");
            } else {
                return new DtoResponse(404, null, "Data Monitoring tidak di temukan");
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat memperbarui data " + e.getMessage());
        }
    }

    public DtoResponse updateMonitoringTanggalAkhir(Monitoring monitoring) {
        try {
            Monitoring existingMonitoring = monitoringRepository.findById(monitoring.getTmoId()).orElse(null);

            if (existingMonitoring != null) {
                BeanUtils.copyProperties(monitoring, existingMonitoring, "tmoId", "hwnId", "tmoKeluhan", "tmoDeskripsi", "tmoPeriode", "tmoTanggalMulai", "tmoStatus");
                monitoringRepository.save(existingMonitoring);
                return new DtoResponse(200, existingMonitoring, "Sukses Memperbarui Data");
            } else {
                return new DtoResponse(404, null, "Data Monitoring tidak di temukan");
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat memperbarui data " + e.getMessage());
        }
    }
}
