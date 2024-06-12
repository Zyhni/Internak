// SchedulerConfig.java
package com.id_co_kelompok7.config;

import com.id_co_kelompok7.service.NotifikasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class NotifikasiConfig {

    @Autowired
    private NotifikasiService notifikasiService;

    @Scheduled(fixedRate = 1800000) // di cek setiap 30 menit
    public void cekNotifikasi() {
        notifikasiService.cekDanBuatNotifikasi();
    }
}
