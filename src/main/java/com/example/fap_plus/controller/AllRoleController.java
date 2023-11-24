package com.example.fap_plus.controller;

import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.entity.Users;
import com.example.fap_plus.service.interface_service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AllRoleController {
    @Autowired
    IUserDAO userDAO;
    @Autowired
    IUserService userService;

    @GetMapping("/{email}")
    public Users getUserByEmail(@PathVariable(name ="email") String email){
        if (email != null && email.equals(userService.getLoginUserEmail()))
            return userService.getLoginUser();
        return null;
    }
}
