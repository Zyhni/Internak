package com.id_co_kelompok7.service;

import com.id_co_kelompok7.model.Hewan;
import com.id_co_kelompok7.model.Kandang;
import com.id_co_kelompok7.model.User;
import com.id_co_kelompok7.repository.HewanRepository;
import com.id_co_kelompok7.repository.KandangRepository;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.vo.HewanVo;
import com.id_co_kelompok7.vo.KandangVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HewanService {

    @Autowired
    private HewanRepository hewanRepository;

    @Autowired
    private KandangRepository kandangRepository;

    public DtoResponse saveHewan(Hewan hewan){
        try {
            Kandang existingKandang = kandangRepository.findById(hewan.getKdgId()).orElse(null);

            if(existingKandang != null){
                Hewan data = new Hewan();
                BeanUtils.copyProperties(hewan, data);
                data.setHwnStatus("Sehat");
                hewanRepository.save(data);
                return new DtoResponse(200, hewan, "Sukses Membuat Data");
            }else {
                return new DtoResponse(404, null, "Hewan Tidak di temukan");
            }

        }catch (Exception e){
            return new DtoResponse(500, null,"Terjadi saat menambahkan data " + e.getMessage());
        }

    }

    public DtoResponse getAllHewanByStatusAndIdKandang(Integer idKandang){
        Kandang kandangDB = kandangRepository.findById(idKandang).orElse(null);

        if(kandangDB != null){
            String status = "Sehat";
            Iterable<Hewan> hewans = hewanRepository.getHewanByIdKandang(idKandang, status);
            List<HewanVo> hewanVos = new ArrayList<>();

            for (Hewan item: hewans){
                HewanVo hewanVo = new HewanVo(item);
                hewanVo.setHwnStatus(hewanVo.getHwnStatus() == null ? "" : hewanVo.getHwnStatus());
                hewanVos.add(hewanVo);
            }
            return new DtoResponse(200, hewanVos, "Data Di temukan");
        }else if(kandangDB == null) {
            return new DtoResponse(404, null, "Data User tidak di temukan");
        }else {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat mengambil data");
        }

    }

    public DtoResponse updateHewan(Hewan hewan){
        try {
            Hewan existingHewan = hewanRepository.findById(hewan.getHwnId()).orElse(null);

            if (existingHewan != null) {
                BeanUtils.copyProperties(hewan, existingHewan, "hwnId", "kdgId");
                hewanRepository.save(existingHewan);
                return new DtoResponse(200, existingHewan, "Sukses Memperbarui Data");
            } else {
                return new DtoResponse(404, null, "Data Hewan tidak di temukan");
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, "Terjadi Kesalahan saat memperbarui data " + e.getMessage());
        }
    }

    public DtoResponse deleteHewan(Integer idHewan){
        try {
            Hewan hewanDB = hewanRepository.findById(idHewan).orElse(null);
            Hewan deleteHewan = new Hewan();
            BeanUtils.copyProperties(hewanDB, deleteHewan);
            deleteHewan.setHwnStatus("Mati");
            hewanRepository.save(deleteHewan);
            return new DtoResponse(200, deleteHewan, "Suskses Menghapus Data Hewan");
        }catch (Exception e){
            return new DtoResponse(500, null, "Terjadi Kesalahan dalam menghapus data " + e.getMessage());
        }
    }
}
