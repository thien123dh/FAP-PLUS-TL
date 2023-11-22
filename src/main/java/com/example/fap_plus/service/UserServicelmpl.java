package com.example.fap_plus.service;

import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private boolean isLoginUser(String email) {
        return email.equals(getLoginUserEmail());
    }

    @Override
    public Page<Users> getUserWithPageable(int page, int size) {
        Pageable usersPageable = PageRequest.of(page, size);
        return userDAO.findAll(usersPageable);
    }

    @Override
    public Users getUserByEmail(String email) {
        if (isLoginUser(email)) {
            Users u = userDAO.findUserByEmail(email);
            return u;
        }

        return null;
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
<<<<<<< HEAD
=======



>>>>>>> 3f4618fed9b0be1924f46f24eab25aaa1fcafeb6
}
