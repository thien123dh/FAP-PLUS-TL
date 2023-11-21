package com.example.fap_plus.service;

import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.entity.Student;
import com.example.fap_plus.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServicelmpl implements IUserService{
    @Autowired
    IUserDAO userDAO;

    @Override
    public List<Users> getAllUsers() {
        return userDAO.findAll().stream().toList();
    }

    @Override
    public Users getUserByEmail(String email) {
        Users u = userDAO.findUserByEmail(email);
        return u;
    }


}
