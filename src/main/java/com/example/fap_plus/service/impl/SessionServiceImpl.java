package com.example.fap_plus.service.impl;

import com.example.fap_plus.DAO.IClassesDetailDAO;
import com.example.fap_plus.DAO.ISessionDAO;
import com.example.fap_plus.entity.ClassesDetail;
import com.example.fap_plus.entity.Session;
import com.example.fap_plus.service.interface_service.IClassesService;
import com.example.fap_plus.service.interface_service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService {
    @Autowired
    ISessionDAO sessionDAO;
    @Autowired
    IClassesService classesService;
    @Autowired
    IClassesDetailDAO scheduleDAO;
    @Override
    public Session getSessionById(Integer sessionId) {
        return sessionDAO.findById(sessionId).get();
    }

    @Override
    public List<Session> getAllSessionOfUserId(Long userId) {
        List<Long> classIdList = classesService.getAllClassesIdListByUserId(userId);

        List<ClassesDetail> scheduleList = scheduleDAO.findScheduleByClassIdList(classIdList);

        List<Session> sessionList = (scheduleList == null)
                ? null : scheduleList.stream().map(ClassesDetail::getSession).distinct().toList();

        return sessionList;
    }
}
