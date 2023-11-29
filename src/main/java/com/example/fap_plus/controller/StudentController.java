package com.example.fap_plus.controller;

import com.example.fap_plus.DAO.IScheduleDAO;
import com.example.fap_plus.DTO.ScheduleDTO;
import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.entity.Schedule;
import com.example.fap_plus.service.interface_service.IClassesService;
import com.example.fap_plus.service.interface_service.ICurriculumService;
import com.example.fap_plus.service.interface_service.IScheduleService;
import com.example.fap_plus.service.interface_service.IUserService;
import com.example.fap_plus.shared_file.SharedVariables;
import com.example.fap_plus.structure.ClassDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    @Autowired
    IScheduleService scheduleService;
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

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleDTO>> getSchedule() {
//        // Lấy ngày hiện tại
//        LocalDate currentDate = LocalDate.now();
//        String dateString = "2023-01-05"; // Chuỗi đại diện cho ngày
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate = LocalDate.parse(dateString, formatter);
        LocalDate currentDate = LocalDate.now();

        String loginUserEmail = userService.getLoginUserEmail();
        return ResponseEntity.status(HttpStatus.OK)
                .body(scheduleService.getScheduleDTOByEmailAndDate(loginUserEmail, currentDate));
    }
}
