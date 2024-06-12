package com.id_co_kelompok7.rest;

import com.id_co_kelompok7.service.NotifikasiService;
import com.id_co_kelompok7.vo.NotifikasiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/notifikasi")
public class NotifikasiRest {

    @Autowired
    private NotifikasiService notifikasiService;

    @GetMapping("/cekNotifikasi")
    public String cekNotifikasi() {
        notifikasiService.cekDanBuatNotifikasi();
        return "Pengecekan dan pembuatan notifikasi selesai";
    }

    @GetMapping("/getAllNotifikasi")
    public List<NotifikasiVo> getAllNotifikasi() {
        return notifikasiService.getAllNotifikasi();
    }
}
