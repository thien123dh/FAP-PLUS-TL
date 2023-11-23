package com.example.fap_plus.controller;

import com.example.fap_plus.DAO.IClassOfStudentDAO;
import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.entity.ClassOfStudent;
import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.entity.Users;
import com.example.fap_plus.service.IClassOfStudentService;
import com.example.fap_plus.service.ICurriculumService;
import com.example.fap_plus.service.IUserService;
import com.example.fap_plus.shared_file.SharedVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    ICurriculumService curriculumService;
    @Autowired
    IClassOfStudentDAO classOfStudentDAO;
    @GetMapping("/curriculum")
    public Page<Curriculum> getCurriculumByLoginUserMajor(@RequestParam(name = "page", defaultValue = "1") int page){
        int pageSize = SharedVariables.CURRICULUM_PAGE_SIZE;
        return curriculumService.getCurriculumByLoginUserMajor(page - 1, pageSize);
    }

    @GetMapping("/class/{id}")
    public ClassOfStudent getClassById(@PathVariable(name = "id") String classId){
        System.out.println(classId);
        Long id = Long.parseLong(classId);
        return classOfStudentDAO.findClassById(id);

    }

}
