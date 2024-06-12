package com.id_co_kelompok7.repository;

import com.id_co_kelompok7.model.Notifikasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.id_co_kelompok7.constant.NotifikasiConstant.qGetNotifikasiByKandang;

public interface NotifikasiRepository extends JpaRepository<Notifikasi, Integer> {

    @Query(value = qGetNotifikasiByKandang, nativeQuery = true)
    List<Notifikasi> getNotifikasiByIdKandang(@Param("idKandang") Integer idKandang, @Param("status") String status);
}
