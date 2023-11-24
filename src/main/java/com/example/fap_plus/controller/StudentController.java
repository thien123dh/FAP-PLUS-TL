package com.example.fap_plus.controller;

import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.service.interface_service.IClassesService;
import com.example.fap_plus.service.interface_service.ICurriculumService;
import com.example.fap_plus.shared_file.SharedVariables;
import com.example.fap_plus.structure.ClassDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    ICurriculumService curriculumService;
    @Autowired
    IClassesService classService;
    @GetMapping("/curriculum")
    public ResponseEntity<Page<Curriculum> > getCurriculumByLoginUserMajor(@RequestParam(name = "page", defaultValue = "1") int page){
        int pageSize = SharedVariables.CURRICULUM_PAGE_SIZE;

        return ResponseEntity.status(HttpStatus.OK)
                .body(curriculumService
                        .getCurriculumByLoginUserMajor(page - 1, pageSize));

//        return curriculumService.getCurriculumByLoginUserMajor(page - 1, pageSize);
    }
    @GetMapping("/class/{id}")
    public ClassDetailDTO getClassById(@PathVariable(name = "id") Long classId){
        return classService.getClassDetailByClassId(classId);
    }
}
