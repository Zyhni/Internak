package com.id_co_kelompok7.constant;

public class NotifikasiConstant {
    public static final String qGetNotifikasiByKandang =
            "SELECT * FROM tr_notifikasi WHERE kdg_id = :idKandang AND ntf_status = :status ORDER BY ntf_id DESC";
}
