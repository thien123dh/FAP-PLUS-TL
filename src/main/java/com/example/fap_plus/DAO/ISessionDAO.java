package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ISessionDAO extends JpaRepository<Session, Integer> {

    @Query("SELECT s FROM Session s " +
            "WHERE :date BETWEEN s.startDate AND s.endDate")
    public Session getSessionByDate(@Param("date") LocalDate date);
}
