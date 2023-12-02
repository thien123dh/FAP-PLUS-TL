package com.example.fap_plus.entity;

import com.example.fap_plus.static_entity.DaySchedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "classes_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long classId;

    @ManyToOne
    @JoinColumn(name = "day_schedule_id")
    private DaySchedule daySchedule;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
}
