package com.example.fap_plus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private boolean isEnabled;
    @OneToOne(fetch = FetchType.LAZY)
    private SubjectDetail subjectDetail;
}
