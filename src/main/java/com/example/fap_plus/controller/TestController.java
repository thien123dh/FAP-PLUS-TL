package com.example.fap_plus.controller;

import com.example.fap_plus.DAO.*;
import com.example.fap_plus.entity.*;
import com.example.fap_plus.service.interface_service.IStudentService;
import com.example.fap_plus.service.interface_service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    IStudentService studentService;
    @Autowired
    ICurriculumDAO curriculumDAO;
    @Autowired
    ISubjectDAO subjectDAO;
    @Autowired
    IUserDAO userDAO;
    @Autowired
    IUserService userService;
    @Autowired
    IClassesDetailDAO scheduleDAO;
    @Autowired
    ISessionDAO sessionDAO;

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/subject/{code}")
    public Subject getSubjectByCode(@PathVariable(name = "code") String code) {
        return subjectDAO.findSubjectByCode(code);
    }

    @PostMapping("/staff/student")
    public void createStudent(@RequestBody Users users){
        userDAO.save(users);
    }

    @GetMapping("/student")
    public List<Users> getAllUsers() {
       return userService.getAllUsers();
    }

    @GetMapping("/staff/student/{email}")
    public Users getUserByEmail(@PathVariable(name ="email") String email){
        return userDAO.findUserByEmail(email);
    }
    @GetMapping("/schedule")
    public List<ClassesDetail> getSchedule() {
        List<Long> list = new ArrayList<>();
        list.add(1L);

        String dateString = "2023-01-05"; // Chuỗi đại diện cho ngày

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);

//        return scheduleDAO.findScheduleByClassIdAndSessionId(list, 1);
        return scheduleDAO.findScheduleByClassIdAndDate(list, localDate);
    }
    @GetMapping("/session")
    public Session getSessionByDate() {
        String dateString = "2023-01-05"; // Chuỗi đại diện cho ngày

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        System.out.println(localDate);
        return sessionDAO.getSessionByDate(localDate);
    }
}
