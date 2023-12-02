package com.example.fap_plus.static_entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "day_schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dayOfWeek;
}
