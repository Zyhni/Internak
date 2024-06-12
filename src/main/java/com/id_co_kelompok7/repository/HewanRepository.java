package com.id_co_kelompok7.repository;

import com.id_co_kelompok7.model.Hewan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.id_co_kelompok7.constant.HewanConstant.*;

public interface HewanRepository extends JpaRepository<Hewan, Integer> {

    @Query(value = qGetHewanByKandang, nativeQuery = true)
    List<Hewan> getHewanByIdKandang(@Param("idKandang") Integer idKandang, @Param("status") String status);
}
