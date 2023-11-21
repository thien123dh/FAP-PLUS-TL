package com.example.fap_plus.DAO;

import com.example.fap_plus.entity.Subject;
import org.aspectj.apache.bcel.classfile.Code;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISubjectDAO extends JpaRepository<Subject, Long> {

    @Query("SELECT s FROM Subject s " +
            "WHERE s.code = :code")
    public Subject findSubjectByCode(@Param("code") String code);

}
