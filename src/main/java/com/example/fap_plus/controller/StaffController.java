package com.example.fap_plus.controller;

import com.example.fap_plus.entity.Users;
import com.example.fap_plus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
