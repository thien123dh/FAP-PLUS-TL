package com.example.fap_plus.controller;

import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.service.interface_service.IClassesService;
import com.example.fap_plus.service.interface_service.ICurriculumService;
import com.example.fap_plus.service.interface_service.IUserService;
import com.example.fap_plus.shared_file.SharedVariables;
import com.example.fap_plus.structure.ClassDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    ICurriculumService curriculumService;
    @Autowired
    IClassesService classService;
    @Autowired
    IUserService userService;
    @GetMapping("/curriculum")
    public ResponseEntity<List<Curriculum>> getCurriculumByLoginUserMajor(){
        //Get Login Student Email
        String loginUserEmail = userService.getLoginUserEmail();

        return ResponseEntity.status(HttpStatus.OK)
                .body(curriculumService.getCurriculumByEmail(loginUserEmail));
    }
    @GetMapping("/class/{id}")
    public ResponseEntity<ClassDetailDTO> getClassById(@PathVariable(name = "id") Long classId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(classService.getClassDetailByClassId(classId));
    }
}
