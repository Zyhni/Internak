package com.id_co_kelompok7.repository;

import com.id_co_kelompok7.model.Hewan;
import com.id_co_kelompok7.model.Kandang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.id_co_kelompok7.constant.KandangConstant.*;

@Repository
public interface KandangRepository  extends JpaRepository<Kandang, Integer> {

    @Query(value = qGetKandangByUser, nativeQuery = true)
    List<Kandang> getKandangByIdUser(@Param("idUser") Integer idUser, @Param("status") String status);
}
