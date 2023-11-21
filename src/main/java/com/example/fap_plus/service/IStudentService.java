package com.example.fap_plus.service;

import com.example.fap_plus.DAO.IStudentDAO;
import com.example.fap_plus.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IStudentService {
    public List<Student> getAllStudent();
}
