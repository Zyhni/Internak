package com.id_co_kelompok7.repository;

import com.id_co_kelompok7.model.KodePos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.id_co_kelompok7.constant.KodePosConstant.qGetKodePosById;

public interface KodePosRepository extends JpaRepository<KodePos, Integer> {
    @Query(value = qGetKodePosById, nativeQuery = true)
    List<KodePos> getKodePosById(@Param("idKodepos") Integer idKodepos);

}
