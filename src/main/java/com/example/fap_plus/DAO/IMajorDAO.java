package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMajorDAO extends JpaRepository<Major, String> {
}
