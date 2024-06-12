package com.id_co_kelompok7.constant;

public class HewanConstant {

    public static final String qGetHewanByKandang =
            "SELECT * FROM ms_hewan WHERE kdg_id = :idKandang AND hwn_status = :status ORDER BY hwn_id DESC";
}
