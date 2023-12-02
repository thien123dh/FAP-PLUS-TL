package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAttendanceDAO extends JpaRepository<Attendance, Long> {
    @Query("SELECT a FROM Attendance a " +
            "WHERE a.userId = :userId AND a.classId = :classId")
    public Attendance findAttendanceByUserIdAndClassId(@Param("userId") Long userId,
                                                       @Param("classId") Long classId);
}
