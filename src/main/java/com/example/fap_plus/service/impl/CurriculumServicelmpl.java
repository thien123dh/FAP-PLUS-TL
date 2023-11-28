package com.example.fap_plus.service.impl;

import com.example.fap_plus.DAO.ICurriculumDAO;
import com.example.fap_plus.DAO.IMajorOfStudentDAO;
import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.entity.Users;
import com.example.fap_plus.service.interface_service.ICurriculumService;
import com.example.fap_plus.service.interface_service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServicelmpl implements ICurriculumService {
    @Autowired
    IUserService userService;
    @Autowired
    ICurriculumDAO curriculumDAO;
    @Autowired
    IMajorOfStudentDAO majorOfStudentDAO;

    @Override
    public List<Curriculum> getCurriculumByEmail(String email){
        Users user = userService.getUserByEmail(email);

        if (user != null) {
            Long majorId = majorOfStudentDAO.findMajorOfStudentById(user.getId(),true).getMajorId();

            List<Curriculum> curriculumList = curriculumDAO.findCurriculumByMajor(majorId);

            curriculumList = curriculumList.stream()
                    .sorted(
                            (o1, o2) -> o1.getSemester().getId().compareTo(o2.getSemester().getId())
                    ).toList();

            return curriculumList;
        }

        return null;
    }

}
