package com.example.fap_plus.service.impl;

import com.example.fap_plus.DAO.IClassOfStudentDAO;
import com.example.fap_plus.DAO.IClassesDAO;
import com.example.fap_plus.DAO.IScheduleDAO;
import com.example.fap_plus.DTO.ScheduleDTO;
import com.example.fap_plus.entity.ClassOfStudent;
import com.example.fap_plus.entity.Classes;
import com.example.fap_plus.entity.Schedule;
import com.example.fap_plus.entity.Users;
import com.example.fap_plus.service.interface_service.IScheduleService;
import com.example.fap_plus.service.interface_service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    private IScheduleDAO scheduleDAO;
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
    private List<Schedule> getScheduleListByEmailAndDate(String email, LocalDate date) {
        Users user = userService.getUserByEmail(email);

        List<ClassOfStudent> classTmpList = classOfStudentDAO.findClassByUserId(user.getId());

        List<Long> classIdList = new ArrayList<>();

        if (classTmpList != null) {
            classIdList = classTmpList.stream().map(ClassOfStudent::getClassesId).toList();
        }

//        for (Long id : classIdList)
//            System.out.println(id);

        List<Schedule> scheduleList = scheduleDAO
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
        List<Schedule> scheduleList = getScheduleListByEmailAndDate(email, date);

        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();

        if (scheduleList == null)
            return null;

        for (Schedule schedule : scheduleList) {
            Integer firstDayOfWeek = getDayOfWeek(0, schedule.getDaySlot().getDayOfWeek());
            Integer secondDayOfWeek = getDayOfWeek(1, schedule.getDaySlot().getDayOfWeek());

//            System.out.println("schedule: " + schedule.getClassId());

            LocalDate localDateTmp = schedule.getSession().getStartDate();
            Classes classes = classesDAO.findById(schedule.getClassId()).get();
            int numberOfSlot = 0;

            while (schedule.getSession().getStartDate().compareTo(localDateTmp) <= 0
                    && localDateTmp.compareTo(schedule.getSession().getEndDate()) <= 0) {

                //DAY THAT HAVE THE SCHEDULE
                if (localDateTmp.getDayOfWeek().getValue() == firstDayOfWeek
                        || localDateTmp.getDayOfWeek().getValue() == secondDayOfWeek) {

//                    System.out.println(numberOfSlot + ", " + localDateTmp);

                    ScheduleDTO dto = new ScheduleDTO(classes, schedule.getSession(), localDateTmp);
                    scheduleDTOList.add(dto);

                    ++numberOfSlot;

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
