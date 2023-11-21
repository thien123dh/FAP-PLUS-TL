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
//    @Column(name = "semester_id")
    @OneToOne
    private Semester semester;
    @OneToOne
    private Major major;
    @OneToOne
    private Subject subject;
}
