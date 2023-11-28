package com.example.fap_plus.service.interface_service;

import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.entity.Users;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICurriculumService {
    public List<Curriculum> getCurriculumByEmail(String email);
}
