package com.id_co_kelompok7.service;

import com.id_co_kelompok7.model.KodePos;
import com.id_co_kelompok7.repository.KodePosRepository;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.vo.KodePosVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KodePosService {
    @Autowired
    private KodePosRepository kodePosRepository;

    public DtoResponse getAllKodePos(){
        Iterable<KodePos> kodePos = kodePosRepository.findAll();
        List<KodePosVo> kodePosVos = new ArrayList<>();

        for (KodePos item: kodePos){
            KodePosVo kodePosVo = new KodePosVo(item);
            kodePosVos.add(kodePosVo);
        }
        return new DtoResponse(200, kodePosVos, "Data Di temukan");
    }

    public DtoResponse getKodePosById(Integer idKodepos){
        Iterable<KodePos> kodePos = kodePosRepository.getKodePosById(idKodepos);
        List<KodePosVo> kodePosVos = new ArrayList<>();
        if(kodePos != null){
            for (KodePos item: kodePos){
                KodePosVo kodePosVo = new KodePosVo(item);
                kodePosVos.add(kodePosVo);
            }
            return new DtoResponse(200, kodePosVos, "Sukses");
        }else {
            return new DtoResponse(404, null, "Data Layanan tidak di temukan");
        }

    }
}
