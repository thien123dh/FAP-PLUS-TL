package com.example.fap_plus.controller;

import com.example.fap_plus.DAO.ICurriculumDAO;
import com.example.fap_plus.entity.*;
import com.example.fap_plus.service.IMajorService;
import com.example.fap_plus.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    IStudentService studentService;
    @Autowired
    IMajorService majorService;
    @Autowired
    ICurriculumDAO curriculumDAO;

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/curriculum")
    public List<Curriculum> getAllMajors() {
        Long majorId = 1L;

        Users user = new Users();

        return curriculumDAO.findCurriculumByMajor(majorId);
    }
}
