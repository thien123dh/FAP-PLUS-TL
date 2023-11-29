package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleDAO extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s " +
            "WHERE s.session.id = :sessionId " +
            "AND s.classId IN (:classIdList)")
    public List<Schedule> findScheduleByClassIdAndSessionId(@Param("classIdList") List<Long> classIdList,
                                                            @Param("sessionId") Integer sessionId);

//    GET THE SCHEDULE IN A SESSION OF DATE
    @Query("SELECT s FROM Schedule s " +
            "WHERE :date BETWEEN s.session.startDate AND s.session.endDate " +
            "AND s.classId IN (:classIdList)")
    public List<Schedule> findScheduleByClassIdAndDate(@Param("classIdList") List<Long> classIdList,
                                                            @Param("date") LocalDate date);

}
