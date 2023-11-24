package com.example.fap_plus.service.impl;

import com.example.fap_plus.DAO.ISubjectDAO;
import com.example.fap_plus.entity.Subject;
import com.example.fap_plus.service.interface_service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServicelmpl implements ISubjectService {
    @Autowired
    ISubjectDAO subjectDAO;
    @Override
    public Subject getSubjectByCode(String code) {
        Subject s = subjectDAO.findSubjectByCode(code);
        return null;
    }
}
