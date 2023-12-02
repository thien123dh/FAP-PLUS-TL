package com.example.fap_plus.DTO;

import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.entity.Session;
import com.example.fap_plus.entity.Slot;
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
    private Slot slot;
    //-1 = not present, 0 = absent, 1 = present
    private int attendanceStatus = -1;
}

