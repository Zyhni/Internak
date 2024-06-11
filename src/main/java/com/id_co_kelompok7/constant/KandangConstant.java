package com.id_co_kelompok7.constant;

public class KandangConstant {
    public static final String qGetKandangByUser =
            "SELECT * FROM ms_kandang WHERE usr_id = :idUser AND kdg_status = :status ORDER BY kdg_id DESC";
}
