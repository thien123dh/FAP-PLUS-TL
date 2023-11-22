package com.example.fap_plus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.websocket.OnError;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String code;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date createDate;
    @ManyToOne
    private Campus campus;
    @ManyToOne(targetEntity = Role.class)
    private Role role;
}
