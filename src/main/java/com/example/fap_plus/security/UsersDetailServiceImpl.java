package com.example.fap_plus.security;

import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.entity.Role;
//import com.example.fap_plus.security.MyUserDetail;
import com.example.fap_plus.entity.Users;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UsersDetailServiceImpl implements UserDetailsService {
    @Autowired
    IUserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDAO.findUserByEmail(username);

        if (user == null)
                throw new UsernameNotFoundException("User not exists by Username or Email");

        return new MyUserDetail(user);
    }
}
