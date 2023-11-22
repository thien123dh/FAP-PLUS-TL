package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.MajorOfStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMajorOfStudentDAO extends JpaRepository<MajorOfStudent, Long> {

    @Query("SELECT m FROM MajorOfStudent m " +
            "Where m.usersId = :usersId " +
            "AND m.isEnabled = :status")
    public MajorOfStudent findMajorOfStudentById(@Param("usersId") Long usersId,
                                                 @Param("status") boolean status);

}
