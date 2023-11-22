package com.example.fap_plus.controller;

import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.entity.Users;
import com.example.fap_plus.service.ICurriculumService;
import com.example.fap_plus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    ICurriculumService curriculumService;

    @GetMapping("/curriculum")
    public Page<Curriculum> getCurriculumByLoginUserMajor(@RequestParam(name = "page", defaultValue = "1") int page){
        int pageSize = 10;
        return curriculumService.getCurriculumByLoginUserMajor(page - 1, pageSize);
    }


}
