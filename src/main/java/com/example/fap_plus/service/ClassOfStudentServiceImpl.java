package com.example.fap_plus.service;

import com.example.fap_plus.DAO.IClassOfStudentDAO;
import com.example.fap_plus.entity.ClassOfStudent;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassOfStudentServiceImpl implements IClassOfStudentService{
    @Autowired
    IClassOfStudentDAO classOfStudentDAO;

    @Override
    public ClassOfStudent getClassById(Long classesId){
        ClassOfStudent c = classOfStudentDAO.findClassById(classesId);
        return c;
    }
}
