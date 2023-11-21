package com.example.fap_plus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "curriculum")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Semester semester;

    private Long majorId;

    @OneToOne
    private Subject subject;
}
