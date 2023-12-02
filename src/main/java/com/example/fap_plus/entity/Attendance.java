package com.example.fap_plus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "attendance")
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long classId;
    private String attendanceString;
}
