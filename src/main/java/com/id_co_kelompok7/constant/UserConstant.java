package com.id_co_kelompok7.constant;

public class UserConstant {

    public static final String qGetLogin =
            "SELECT * FROM ms_user " +
                    "WHERE usr_email = :email AND usr_password = :password";

    public static final String qGetEmailUser =
            "SELECT usr_email FROM ms_user WHERE usr_email = :email";

    public static final String qGetUserByEmail =
            "SELECT * FROM ms_user WHERE usr_email = :email";

    public static final String qGetUserByPassword =
            "SELECT * FROM ms_user WHERE usr_password = :password";
    
}
