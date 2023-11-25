package com.example.fap_plus.controller;

import com.example.fap_plus.DTO.JWTAuthResponse;
import com.example.fap_plus.DTO.LoginDTO;
import com.example.fap_plus.security.JwtTokenProvider;
import com.example.fap_plus.service.interface_service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IAuthService authService;
    @Autowired
    private JwtTokenProvider provider;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDTO loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setRole(provider.getRole(token));

        return ResponseEntity.ok(jwtAuthResponse);
    }

}
