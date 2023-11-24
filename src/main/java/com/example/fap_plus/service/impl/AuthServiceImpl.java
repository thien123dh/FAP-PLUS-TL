package com.example.fap_plus.service.impl;

import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.DTO.LoginDTO;
import com.example.fap_plus.security.JwtTokenProvider;
import com.example.fap_plus.service.interface_service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

//    public AuthServiceImpl(
//            JwtTokenProvider jwtTokenProvider,
//            IUserDAO userRepository,
//            PasswordEncoder passwordEncoder,
//            AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//        this.userDAO = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtTokenProvider = jwtTokenProvider;
//    }

    @Override
    public String login(LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }
}
