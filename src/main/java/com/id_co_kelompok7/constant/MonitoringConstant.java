package com.id_co_kelompok7.constant;

public class MonitoringConstant {
    public static final String qGetMonitoringByHewan =
            "SELECT * FROM tr_monitoring WHERE hwn_id = :idHewan AND tmo_status = :status ORDER BY tmo_id DESC";
}
