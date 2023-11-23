package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.Classes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClassesDAO extends JpaRepository<Classes, Integer> {
    @Query("SELECT c FROM Classes c " +
            "WHERE c.teacher.email = :email")
    public Page<Classes> findClassesByTeacherId(Pageable pageable, String email);


}
