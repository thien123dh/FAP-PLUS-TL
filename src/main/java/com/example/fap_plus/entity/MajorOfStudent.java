package com.example.fap_plus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "major_of_student")
public class MajorOfStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @OneToOne
    private Major major;
}
