package com.id_co_kelompok7.rest;

import com.id_co_kelompok7.model.Hewan;
import com.id_co_kelompok7.model.Kandang;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.service.HewanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/hewan")
public class HewanRest {

    @Autowired
    private HewanService hewanService;

    public HewanRest(HewanService hewanService){
        this.hewanService = hewanService;
    }

    @GetMapping("/getHewanKandang")
    public DtoResponse getAllHewanKandangByStatus(@RequestParam("idKandang") Integer idKandang){
        return hewanService.getAllHewanByStatusAndIdKandang(idKandang);
    }

    @PostMapping("/saveHewanKandang")
    public DtoResponse saveHewan(@RequestBody Hewan hewan){
        return hewanService.saveHewan(hewan);
    }

    @PostMapping("/deleteHewan")
    public DtoResponse deleteHewan(@RequestParam("idHewan") Integer idHewan){
        return hewanService.deleteHewan(idHewan);
    }

    @PostMapping("/updateHewanKandang")
    public DtoResponse updateHewan(@RequestBody Hewan hewan){
        return hewanService.updateHewan(hewan);
    }
}
