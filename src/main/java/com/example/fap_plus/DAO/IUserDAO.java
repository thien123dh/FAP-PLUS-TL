package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserDAO extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u " +
            "WHERE u.email = :email")
    public Users findUserByEmail(@Param("email") String email);

}
