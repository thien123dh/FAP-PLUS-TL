package com.example.fap_plus.service;

import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.entity.Student;
import com.example.fap_plus.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Override
    public String getLoginUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            // Kiểm tra xem người dùng có được xác thực không (đã đăng nhập hay chưa)
            if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String email = userDetails.getUsername();

                return email;
            }
        }

        return null;
    }


}
