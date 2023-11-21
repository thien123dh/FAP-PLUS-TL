package com.example.fap_plus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subject_detail")
public class SubjectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
