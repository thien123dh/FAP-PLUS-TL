package com.example.fap_plus.controller;

import com.example.fap_plus.DAO.IStudentDAO;
import com.example.fap_plus.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicController {
//    @Autowired
//    IStudentDAO studentDAO;

    @GetMapping("/public")
    public String getAllStudent() {
        return "Hello";
    }

}
