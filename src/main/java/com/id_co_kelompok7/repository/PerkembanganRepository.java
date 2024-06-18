package com.id_co_kelompok7.repository;

import com.id_co_kelompok7.model.Perkembangan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.id_co_kelompok7.constant.PerkembanganConstant.qGetPerkembanganById;

public interface PerkembanganRepository extends JpaRepository<Perkembangan, Integer> {
    @Query(value = qGetPerkembanganById, nativeQuery = true)
    List<Perkembangan> getPerkembanganById(@Param("idMonitoring") Integer idMonitoring);
}
