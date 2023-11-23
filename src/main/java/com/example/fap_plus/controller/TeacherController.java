package com.example.fap_plus.controller;

import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.service.IClassesService;
import com.example.fap_plus.service.IUserService;
import com.example.fap_plus.shared_file.SharedVariables;
import org.aspectj.weaver.IUnwovenClassFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    IUserService userService;
    @Autowired
    IClassesService classesService;
    @GetMapping("/class")
    public Page<Classes> getAllClasses(@RequestParam(name = "page", defaultValue = "1") int page) {
        String email = userService.getLoginUserEmail();

        return classesService.getAllClassByTeacherEmail(page - 1, SharedVariables.CLASSES_PAGE_SIZE, email);
    }
}
