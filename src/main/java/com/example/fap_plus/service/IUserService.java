package com.example.fap_plus.service;

import com.example.fap_plus.entity.Users;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {
    public List<Users> getAllUsers();
    public Page<Users> getUserWithPageable(int page, int size);
    public Users getLoginUser();
    public String getLoginUserEmail();
}
