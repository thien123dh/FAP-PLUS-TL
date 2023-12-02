package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.ClassesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IClassesDetailDAO extends JpaRepository<ClassesDetail, Long> {
    @Query("SELECT s FROM ClassesDetail s " +
            "WHERE s.session.id = :sessionId " +
            "AND s.classId IN (:classIdList)")
    public List<ClassesDetail> findScheduleByClassIdAndSessionId(@Param("classIdList") List<Long> classIdList,
                                                            @Param("sessionId") Integer sessionId);

//    GET THE SCHEDULE IN A SESSION OF DATE
    @Query("SELECT s FROM ClassesDetail s " +
            "WHERE :date BETWEEN s.session.startDate AND s.session.endDate " +
            "AND s.classId IN (:classIdList)")
    public List<ClassesDetail> findScheduleByClassIdAndDate(@Param("classIdList") List<Long> classIdList,
                                                            @Param("date") LocalDate date);

    @Query("SELECT s FROM ClassesDetail s " +
            "WHERE s.classId IN :classIdList")
    public List<ClassesDetail> findScheduleByClassIdList(@Param("classIdList") List<Long> classIdList);
}
