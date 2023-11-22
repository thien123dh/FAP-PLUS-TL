package com.example.fap_plus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Users teacher;
    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
