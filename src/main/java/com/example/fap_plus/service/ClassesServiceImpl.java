package com.example.fap_plus.service;

import com.example.fap_plus.DAO.IClassOfStudentDAO;
import com.example.fap_plus.DAO.IClassesDAO;
import com.example.fap_plus.DAO.IUserDAO;
import com.example.fap_plus.entity.ClassOfStudent;
import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.entity.Users;
import com.example.fap_plus.structure.ClassDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService {
    @Autowired
    IClassesDAO classesDAO;
    @Autowired
    IClassOfStudentDAO classOfStudentDAO;
    @Autowired
    IUserDAO userDAO;
    @Override
    public Page<Classes> getAllClassByTeacherEmail(int page, int size, String email) {
        Pageable pageable = PageRequest.of(page, size);

        return classesDAO.findClassesByTeacherId(pageable, email);
    }

    @Override
    public ClassDetailDTO getClassDetailByClassId(Long classId) {
        List<ClassOfStudent> classOfStudentList = classOfStudentDAO.findClassByClassId(classId);

        List<Long> studentIdList = classOfStudentList.stream().map(ClassOfStudent::getUsersId).toList();

        List<Users> usersList = userDAO.findAllById(studentIdList);
        Classes classes = classesDAO.findById(classId).get();

        ClassDetailDTO classDetailDTO = new ClassDetailDTO(classes, usersList);

        return classDetailDTO;
    }


}
