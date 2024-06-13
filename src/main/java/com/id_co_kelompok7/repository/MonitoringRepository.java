package com.id_co_kelompok7.repository;

import com.id_co_kelompok7.model.Monitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.id_co_kelompok7.constant.MonitoringConstant.qGetMonitoringByHewan;

public interface MonitoringRepository extends JpaRepository<Monitoring, Integer> {
    @Query(value = qGetMonitoringByHewan, nativeQuery = true)
    List<Monitoring> getMonitoringByIdHewan(@Param("idHewan") Integer idHewan, @Param("status") String status);
}
