package com.example.fap_plus.service;

import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.entity.Users;
import org.springframework.data.domain.Page;

public interface ICurriculumService {
    public Page<Curriculum> getCurriculumByLoginUserMajor(int page, int size);
}
