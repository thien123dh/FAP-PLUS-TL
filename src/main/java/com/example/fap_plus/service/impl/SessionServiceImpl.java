package com.example.fap_plus.service.impl;

import com.example.fap_plus.DAO.ISessionDAO;
import com.example.fap_plus.entity.Session;
import com.example.fap_plus.service.interface_service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements ISessionService {
    @Autowired
    ISessionDAO sessionDAO;
    @Override
    public Session getSessionById(Integer sessionId) {
        return sessionDAO.findById(sessionId).get();
    }
}
