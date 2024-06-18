package com.id_co_kelompok7.rest;

import com.id_co_kelompok7.model.Monitoring;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.service.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/monitoring")
public class MonitoringRest {
    @Autowired
    private MonitoringService monitoringService;

    public MonitoringRest(MonitoringService monitoringService){
        this.monitoringService = monitoringService;
    }

    @GetMapping("/getMonitoringHewan")
    public DtoResponse getAllMonitoringByStatus(@RequestParam("idHewan") Integer idHewan){
        return monitoringService.getAllMonitoringByStatusAndIdHewan(idHewan);
    }

    @PostMapping("/saveMonitoringHewan")
    public DtoResponse saveMonitoring(@RequestBody Monitoring monitoring){
        return monitoringService.saveMonitoring(monitoring);
    }

    @PostMapping("/updateTanggalAkhir")
    public DtoResponse updateTanggalAkhir(@RequestBody Monitoring monitoring){
        return monitoringService.updateMonitoringTanggalAkhir(monitoring);
    }
    @PostMapping("/updateSelesai")
    public DtoResponse updateSelesai(@RequestBody Monitoring monitoring){
        return monitoringService.updateMonitoringStatus(monitoring);
    }
}
