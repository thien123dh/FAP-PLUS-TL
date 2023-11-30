package com.example.fap_plus.entity;

import com.example.fap_plus.static_entity.DaySlot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long classId;

    @ManyToOne
    @JoinColumn(name = "day_slot_id")
    private DaySlot daySlot;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
}
