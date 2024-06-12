package com.id_co_kelompok7.rest;

import com.id_co_kelompok7.model.Kandang;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.service.KandangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/kandang")
public class KandangRest {

    @Autowired
    private KandangService kandangService;

    public KandangRest(KandangService kandangService){
        this.kandangService = kandangService;
    }

    @GetMapping("/getKandangUser")
    public DtoResponse getAllKandangUserByStatus(@RequestParam("idUser") Integer idUser){
        return kandangService.getAllKandangByStatusAndIdUser(idUser);
    }

    @PostMapping("/saveKandangUser")
    public DtoResponse saveKandang(@RequestBody Kandang kandang){
        return kandangService.saveKandang(kandang);
    }

    @PostMapping("/deleteKandang")
    public DtoResponse deleteKandang(@RequestParam("idKandang") Integer idKandang){
        return kandangService.deleteKandang(idKandang);
    }

    @PostMapping("/updateKandangUser")
    public DtoResponse updateKandang(@RequestBody Kandang kandang){
        return kandangService.updateKandang(kandang);
    }
}
