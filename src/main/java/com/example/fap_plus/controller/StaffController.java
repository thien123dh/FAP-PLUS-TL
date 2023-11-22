package com.example.fap_plus.controller;

import com.example.fap_plus.entity.Users;
import com.example.fap_plus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    IUserService userService;
    @GetMapping("/student")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/pageable-student")
    public Page<Users> getUserPageable(@RequestParam(name = "page", defaultValue = "1") int page) {
        int pageSize = 2;
        return userService.getUserWithPageable(page - 1, pageSize);
    }
}
