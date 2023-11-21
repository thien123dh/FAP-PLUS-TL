package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IStudentDAO extends JpaRepository<Student, Long> {
}
