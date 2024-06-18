package com.id_co_kelompok7.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.id_co_kelompok7.model.Monitoring;
import com.id_co_kelompok7.model.Perkembangan;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.service.MonitoringService;
import com.id_co_kelompok7.service.PerkembanganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin
@RequestMapping("/perkembangan")
public class PerkembanganRest {
    @Autowired
    private PerkembanganService perkembanganService;

    public PerkembanganRest(PerkembanganService perkembanganService){
        this.perkembanganService = perkembanganService;
    }

    @GetMapping("/getAllPerkembangan")
    public DtoResponse getAllPerkembangan(){
        return perkembanganService.getAllPerkembangan();
    }
    @GetMapping("/getPerkembanganById")
    public DtoResponse getKodePosById(@RequestParam("idPerkembangan") Integer idPerkembangan){
        return perkembanganService.getPerkembanganById(idPerkembangan);
    }

    @PostMapping(value = "/savePerkembangan", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DtoResponse savePerkembangan(
            @RequestParam("tmoId") Integer tmoId,
            @RequestParam("dtpDeskripsi") String dtpDeskripsi,
            @RequestParam("dtpFile") MultipartFile dtpFile) {

        Perkembangan perkembangan = new Perkembangan();
        perkembangan.setTmoId(tmoId);
        perkembangan.setDtpDeskripsi(dtpDeskripsi);
        perkembangan.setDtpFile(dtpFile.getOriginalFilename()); // Atau simpan file dengan cara lain

        return perkembanganService.savePerkembangan(perkembangan);
    }
}
