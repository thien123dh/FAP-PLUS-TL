package com.example.fap_plus.service;

import com.example.fap_plus.DAO.IStudentDAO;
import com.example.fap_plus.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    IStudentDAO studentDAO;

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.findAll();
    }
}
