package com.example.fap_plus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "class_of_student")
public class ClassOfStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usersId;
    private Long classesId;

}
