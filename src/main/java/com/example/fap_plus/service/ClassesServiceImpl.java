package com.example.fap_plus.service;

import com.example.fap_plus.DAO.IClassesDAO;
import com.example.fap_plus.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl implements IClassesService {
    @Autowired
    IClassesDAO classesDAO;
    @Override
    public Page<Classes> getAllClassByTeacherEmail(int page, int size, String email) {
        Pageable pageable = PageRequest.of(page, size);

        return classesDAO.findClassesByTeacherId(pageable, email);
    }

    @Override
    public Classes getClassById(String id){
        Classes c = classesDAO.findClassById(id);
        return c;
    }
}
