package com.example.fap_plus.controller;

import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.service.IClassesService;
import com.example.fap_plus.service.IUserService;
import com.example.fap_plus.shared_file.SharedVariables;
import com.example.fap_plus.structure.ClassDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/class/{id}")
    public ClassDetailDTO getClassDetailsById(@PathVariable("id") Long classId) {
        return classesService.getClassDetailByClassId(classId);
    }
}
