package com.example.fap_plus.service.interface_service;

import com.example.fap_plus.DTO.ScheduleDTO;

import java.time.LocalDate;
import java.util.List;

public interface IClassesDetailService {
    public List<ScheduleDTO> getScheduleDTOByEmailAndDate(String email, LocalDate date);

}
