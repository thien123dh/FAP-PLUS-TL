package com.example.fap_plus.service;

import com.example.fap_plus.DAO.ICurriculumDAO;
import com.example.fap_plus.DAO.IMajorOfStudentDAO;
import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.entity.Major;
import com.example.fap_plus.entity.MajorOfStudent;
import com.example.fap_plus.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CurriculumServicelmpl implements ICurriculumService {
    @Autowired
    IUserService userService;
    @Autowired
    ICurriculumDAO curriculumDAO;
    @Autowired
    IMajorOfStudentDAO majorOfStudentDAO;

    @Override
    public Page<Curriculum> getCurriculumByLoginUserMajor(int page, int size){
        Users loginUser = userService.getLoginUser();

        if (loginUser != null) {
            Pageable pageable = PageRequest.of(page, size);
            Long majorId = majorOfStudentDAO.findMajorOfStudentById(loginUser.getId(),true).getMajorId();
            return curriculumDAO.findCurriculumByMajor(pageable, majorId);
        }

        return null;
    }

}
