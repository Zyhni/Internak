package com.id_co_kelompok7.repository;

import com.id_co_kelompok7.model.User;
import com.id_co_kelompok7.constant.UserConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = UserConstant.qGetLogin, nativeQuery = true)
    User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value = UserConstant.qGetEmailUser, nativeQuery = true)
    String getExistingEmail(@Param("email") String email);

    @Query(value = UserConstant.qGetUserByEmail, nativeQuery = true)
    User findUserByEmail(@Param("email") String email);

    @Query(value = UserConstant.qGetUserByPassword, nativeQuery = true)
    User findUserByPassword(@Param("password") String password);

}
