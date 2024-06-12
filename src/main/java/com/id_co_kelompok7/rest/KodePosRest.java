package com.id_co_kelompok7.rest;

import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.service.KodePosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/kodepos")
public class KodePosRest {
    @Autowired
    private KodePosService kodePosService;

    public KodePosRest(KodePosService kodePosService){
        this.kodePosService = kodePosService;
    }

    @GetMapping("/getAllKodePos")
    public DtoResponse getAllKodePos(){
        return kodePosService.getAllKodePos();
    }
    @GetMapping("/getKodePosById")
    public DtoResponse getKodePosById(@RequestParam("idKodepos") Integer idKodepos){
        return kodePosService.getKodePosById(idKodepos);
    }
}
