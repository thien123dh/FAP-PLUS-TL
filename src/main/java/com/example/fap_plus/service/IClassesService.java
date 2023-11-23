package com.example.fap_plus.service;

import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.structure.ClassDetailDTO;
import org.springframework.data.domain.Page;

public interface IClassesService {
    public Page<Classes> getAllClassByTeacherEmail(int page, int size, String email);

    public ClassDetailDTO getClassDetailByClassId(Long classId);
}
