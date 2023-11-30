package com.example.fap_plus.DTO;

import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.entity.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private Integer slotNumber;

    private Classes classes;
    private Session session;
    private LocalDate date;
}

