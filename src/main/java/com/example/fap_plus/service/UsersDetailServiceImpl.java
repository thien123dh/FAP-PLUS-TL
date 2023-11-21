package com.example.fap_plus.service;

import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.DTO.MyUserDetail;
import com.example.fap_plus.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsersDetailServiceImpl implements UserDetailsService {
    @Autowired
    IUserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDAO.findUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetail(user);
    }
}
