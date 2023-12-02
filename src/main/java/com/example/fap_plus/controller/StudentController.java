package com.example.fap_plus.controller;

import com.example.fap_plus.DTO.ScheduleDTO;
import com.example.fap_plus.entity.Curriculum;
import com.example.fap_plus.entity.Session;
import com.example.fap_plus.entity.Users;
import com.example.fap_plus.service.interface_service.*;
import com.example.fap_plus.structure.ClassDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    IClassesDetailService scheduleService;
    @Autowired
    ISessionService sessionService;
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

    @GetMapping("/all-session")
    public ResponseEntity<List<Session>> getAllSessionOfStudent() {
        Users user = userService.getLoginUser();

        List<Session> sessionList = sessionService.getAllSessionOfUserId(user.getId());

        return ResponseEntity.status(HttpStatus.OK)
                .body(sessionList);
    }
    @GetMapping("/schedule")
    public ResponseEntity< List<ScheduleDTO> > getSchedule(
            @RequestParam(name = "session-id", required = false) Integer sessionId) {

        Session requestSession = sessionId != null ?
                sessionService.getSessionById(sessionId) : null;

        //Get Session Day
        LocalDate currentDate = requestSession == null  ?
                LocalDate.now() : requestSession.getStartDate();

        String loginUserEmail = userService.getLoginUserEmail();

        return ResponseEntity.status(HttpStatus.OK)
                .body(scheduleService.getScheduleDTOByEmailAndDate(loginUserEmail, currentDate));
    }
}
