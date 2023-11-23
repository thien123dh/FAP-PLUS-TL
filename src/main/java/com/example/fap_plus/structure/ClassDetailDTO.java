package com.example.fap_plus.structure;

import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClassDetailDTO {
    private Classes classes;
    private List<Users> studentList;
}
