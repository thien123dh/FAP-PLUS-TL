package com.example.fap_plus.controller;

import com.example.fap_plus.DAO.ICurriculumDAO;
import com.example.fap_plus.DAO.ISubjectDAO;
import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.entity.*;
import com.example.fap_plus.service.IMajorService;
import com.example.fap_plus.service.IStudentService;
import com.example.fap_plus.service.IUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    ISubjectDAO subjectDAO;
    @Autowired
    IUserDAO userDAO;
    @Autowired
    IUserService userService;

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

    @GetMapping("/subject/{code}")
    public Subject getSubjectByCode(@PathVariable(name = "code") String code) {
        return subjectDAO.findSubjectByCode(code);
    }

    @PostMapping("/staff/student")
    public void createStudent(@RequestBody Users users){
        userDAO.save(users);
    }

    @GetMapping("/staff/student")
    public List<Users> getAllUsers() {
       return userService.getAllUsers();
    }

    @GetMapping("/staff/student/{email}")
    public Users getUserByEmail(@PathVariable(name ="email") String email){
        return userDAO.findUserByEmail(email);
    }
}
