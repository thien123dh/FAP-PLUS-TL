package com.example.fap_plus.service.impl;

import com.example.fap_plus.DAO.IClassOfStudentDAO;
import com.example.fap_plus.DAO.IClassesDAO;
import com.example.fap_plus.DAO.IClassesDetailDAO;
import com.example.fap_plus.DTO.ScheduleDTO;
import com.example.fap_plus.entity.ClassOfStudent;
import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.entity.ClassesDetail;
import com.example.fap_plus.entity.Users;
import com.example.fap_plus.service.interface_service.IClassesDetailService;
import com.example.fap_plus.service.interface_service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassesDetailServiceImpl implements IClassesDetailService {
    @Autowired
    private IClassesDetailDAO scheduleDAO;
    @Autowired
    private IClassOfStudentDAO classOfStudentDAO;
    @Autowired
    private IUserService userService;
    @Autowired
    private IClassesDAO classesDAO;
    private int NUMBER_OF_SLOT = 20;
    private LocalDate getMondayDate(LocalDate date) {
        LocalDate monday = date.with(DayOfWeek.MONDAY);

        return monday;
    }
    private LocalDate getSundayDate(LocalDate date) {
        LocalDate sunday = date.with(DayOfWeek.SUNDAY);

        return sunday;
    }
    private List<ClassesDetail> getScheduleListByEmailAndDate(String email, LocalDate date) {
        Users user = userService.getUserByEmail(email);

        List<ClassOfStudent> classTmpList = classOfStudentDAO.findClassByUserId(user.getId());

        List<Long> classIdList = new ArrayList<>();

        if (classTmpList != null) {
            classIdList = classTmpList.stream().map(ClassOfStudent::getClassesId).toList();
        }

//        for (Long id : classIdList)
//            System.out.println(id);

        List<ClassesDetail> scheduleList = scheduleDAO
                .findScheduleByClassIdAndDate(classIdList, date);

//        for ()

        return scheduleList;
    }

    private Integer getDayOfWeek(int index, String text) {
        String[] values = text.split(",");

        return Integer.parseInt(values[index]) + 1;
    }

    @Override
    public List<ScheduleDTO> getScheduleDTOByEmailAndDate(String email, LocalDate date) {
        Map<String, Integer> slotCounter = new HashMap<String, Integer>();

        List<ClassesDetail> scheduleList = getScheduleListByEmailAndDate(email, date);

        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();

        if (scheduleList == null)
            return null;

        for (ClassesDetail schedule : scheduleList) {
            Integer firstDayOfWeek = getDayOfWeek(0, schedule.getDaySchedule().getDayOfWeek());
            Integer secondDayOfWeek = getDayOfWeek(1, schedule.getDaySchedule().getDayOfWeek());

//            System.out.println("schedule: " + schedule.getClassId());

            LocalDate localDateTmp = schedule.getSession().getStartDate();
            Classes classes = classesDAO.findById(schedule.getClassId()).get();
            int numberOfSlot = 0;

            while (schedule.getSession().getStartDate().compareTo(localDateTmp) <= 0
                    && localDateTmp.compareTo(schedule.getSession().getEndDate()) <= 0) {

                //DAY THAT HAVE THE SCHEDULE
                if (localDateTmp.getDayOfWeek().getValue() == firstDayOfWeek
                        || localDateTmp.getDayOfWeek().getValue() == secondDayOfWeek) {

                    String subjectCode = classes.getSubject().getCode();

                    ScheduleDTO dto = new ScheduleDTO(++numberOfSlot, classes, schedule.getSession(), localDateTmp, schedule.getSlot());
                    scheduleDTOList.add(dto);

//                    System.out.println(subjectCode + " SlotNumber: #" + dto.getSlotNumber());

                    if (numberOfSlot >= NUMBER_OF_SLOT)
                        break;
                }
                //PlusDay
                localDateTmp = localDateTmp.plusDays(1);
            }
        }

        scheduleDTOList = scheduleDTOList.stream().sorted(
                (o1, o2) -> o1.getDate().compareTo(o2.getDate())
        ).toList();

        return scheduleDTOList;
    }
}
