package com.example.ClinicalApp.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.userEmail = :userEmail")
    UserEntity findByEmail(@Param("userEmail") String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName")
    UserEntity findByName(@Param("userName") String userName);

    @Query("SELECT u.userEmail FROM UserEntity u")
    List<String> findALLEmail();

}
