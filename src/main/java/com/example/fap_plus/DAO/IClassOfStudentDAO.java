package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.ClassOfStudent;
import com.example.fap_plus.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClassOfStudentDAO extends JpaRepository<ClassOfStudent, Long> {
    @Query("SELECT c FROM ClassOfStudent c " +
            "WHERE c.classesId = :classesId")
    public List<ClassOfStudent> findClassByClassId(@Param("classesId") Long classesId);

    @Query("SELECT c FROM ClassOfStudent c " +
            "WHERE c.usersId = :userId")
    public List<ClassOfStudent> findClassByUserId(@Param("userId") Long userId);
}
