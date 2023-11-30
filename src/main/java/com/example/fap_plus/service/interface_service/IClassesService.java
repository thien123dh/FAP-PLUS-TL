package com.example.fap_plus.service.interface_service;

import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.structure.ClassDetailDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IClassesService {
    public Page<Classes> getAllClassByTeacherEmail(int page, int size, String email);

    public ClassDetailDTO getClassDetailByClassId(Long classId);

    public List<Long> getAllClassesIdListByUserId(Long userId);
}
