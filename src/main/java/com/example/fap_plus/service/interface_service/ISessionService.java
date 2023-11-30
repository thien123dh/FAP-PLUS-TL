package com.example.fap_plus.service.interface_service;

import com.example.fap_plus.entity.Session;

import java.util.List;

public interface ISessionService {
    public Session getSessionById(Integer sessionId);

    public List<Session> getAllSessionOfUserId(Long userId);
}
