package com.example.fap_plus.service.impl;

import com.example.fap_plus.DAO.IMajorDAO;
import com.example.fap_plus.entity.Major;
import com.example.fap_plus.service.interface_service.IMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl implements IMajorService {
    @Autowired
    IMajorDAO majorDAO;
    @Override
    public Major getMajorByCode(String id) {
        Major m = majorDAO.findById(id).get();
//        m.setSubjectList(m.getSubjectList());

        return m;
    }
}
