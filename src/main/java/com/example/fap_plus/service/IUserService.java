package com.example.fap_plus.service;

import com.example.fap_plus.entity.Student;
import com.example.fap_plus.entity.Users;

import java.util.List;

public interface IUserService {
    public List<Users> getAllUsers();

    public Users getUserByEmail(String email);
}
