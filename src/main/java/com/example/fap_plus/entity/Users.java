package com.example.fap_plus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String code;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date createDate;
    @ManyToOne(targetEntity = Role.class)
    private Role role;
}
