package com.id_co_kelompok7.service;

import com.id_co_kelompok7.model.Hewan;
import com.id_co_kelompok7.model.Kandang;
import com.id_co_kelompok7.model.Monitoring;
import com.id_co_kelompok7.repository.HewanRepository;
import com.id_co_kelompok7.repository.MonitoringRepository;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.vo.KandangVo;
import com.id_co_kelompok7.vo.MonitoringVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonitoringService {
    @Autowired
    MonitoringRepository monitoringRepository;

    @Autowired
    HewanRepository hewanRepository;

    public DtoResponse saveMonitoring(Monitoring monitoring){
        try {
            Hewan existingHewan = hewanRepository.findById(monitoring.getTmoId()).orElse(null);

            if(existingHewan != null){
                Monitoring data = new Monitoring();
                BeanUtils.copyProperties(monitoring, data);
                data.setTmoTangggalMulai(LocalDate.now());

                LocalDate tmoTanggalMulai = data.getTmoTangggalMulai();
                if("Harian".equals(data.getTmoPeriode())){
                    data.setTmoTangggalAkhir(tmoTanggalMulai.plusDays(1));
                }else if("Bulanan".equals(data.getTmoPeriode())){
                    data.setTmoTangggalAkhir(tmoTanggalMulai.plusWeeks(1));
                }else{
                    data.setTmoTangggalAkhir(tmoTanggalMulai.plusMonths(1));
                }
                data.setTmoStatus("Proses");
                monitoringRepository.save(data);
                return new DtoResponse(200, monitoring, "Sukses Membuat Data");
            }else {
                return new DtoResponse(404, null, "Monitoring Tidak di temukan");
            }

        }catch (Exception e){
            return new DtoResponse(500, null,"Terjadi saat menambahkan data " + e.getMessage());
        }

    }

    public DtoResponse getAllMonitoringByStatusAndIdHewan(Integer idHewan){
        Hewan hewanDB = hewanRepository.findById(idHewan).orElse(null);

        if(hewanDB != null){
            String status = "Proses";
            Iterable<Monitoring> monitorings = monitoringRepository.getMonitoringByIdHewan(idHewan, status);
            List<MonitoringVo> monitoringVos = new ArrayList<>();

            for (Monitoring item: monitorings){
                MonitoringVo monitoringVo = new MonitoringVo(item);
                monitoringVo.setTmoStatus(monitoringVo.getTmoStatus() == null ? "" : monitoringVo.getTmoStatus());
                monitoringVos.add(monitoringVo);
            }
            return new DtoResponse(200, monitoringVos, "Data Di temukan");
        }else if(hewanDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }

    }
    public DtoResponse updateMonitoring(Monitoring monitoring){
        try {
            Monitoring existingMonitoring = monitoringRepository.findById(monitoring.getTmoId()).orElse(null);

            if (existingMonitoring != null) {
                LocalDate today = LocalDate.now();
                if(today.equals(monitoring.getTmoTangggalAkhir())){
                    if("Selesai".equals(existingMonitoring.getTmoStatus())){
                        existingMonitoring.setTmoStatus("Selesai");
                    }else{
                        existingMonitoring.setTmoTangggalAkhir(monitoring.getTmoTangggalAkhir());
                    }
                    monitoringRepository.save(existingMonitoring);
                    return new DtoResponse(200, existingMonitoring, "Sukses Memperbarui Data");
                }else {
                    return new DtoResponse(403, null, "Hanya dapat mengubah data pada tanggal akhir");
                }
            } else {
                return new DtoResponse(404, null, "Data Monitoring tidak di temukan");
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat memperbarui data " + e.getMessage());
        }
    }
}
