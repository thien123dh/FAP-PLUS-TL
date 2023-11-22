package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.Curriculum;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ICurriculumDAO extends JpaRepository<Curriculum, Integer> {
    @Query("SELECT c FROM Curriculum c " +
            "WHERE c.majorId = :majorId")
    public List<Curriculum> findCurriculumByMajor(@Param("majorId") Long majorId);
}
