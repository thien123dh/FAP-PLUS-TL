package com.example.fap_plus.service;

import com.example.fap_plus.DAO.ISubjectDAO;
import com.example.fap_plus.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectServicelmpl implements ISubjectService {
@Autowired
    ISubjectDAO subjectDAO;

    @Override
    public Subject getSubjectByCode(String code) {
        Subject s = subjectDAO.findSubjectByCode(code);
        return null;
    }
}
