package com.acem.demo.controller;

import com.acem.demo.entity.Schedule;
import com.acem.demo.entity.enums.CourseName;
import com.acem.demo.entity.enums.DayEnum;
import com.acem.demo.entity.enums.SectionEnum;
import com.acem.demo.entity.enums.Year;
import com.acem.demo.request.ScheduleRequest;
import com.acem.demo.response.Response;
import com.acem.demo.service.ScheduleService;
import com.acem.demo.util.ModelMapperUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public Response get(@Validated @RequestBody ScheduleRequest request){
        Schedule tempSchedule = toSchedule(request);
        return scheduleService.get(tempSchedule);
    }

    @PostMapping
    public Response save(@Validated @RequestBody ScheduleRequest request){
        Schedule tempSchedule = toSchedule(request);
        return scheduleService.save(tempSchedule);
    }

    private String generateScheduleCode(Schedule request){
        StringBuilder stringBuilder = new StringBuilder(request.getBatch().toString());
        stringBuilder.append(request.getSection().toString());
        stringBuilder.append(request.getDay().ordinal());
        stringBuilder.append(request.getCourse().toString());

        return stringBuilder.toString();
    }

    private Schedule toSchedule(ScheduleRequest request){
        Schedule tempSchedule = new Schedule();
        tempSchedule.setBatch(Year.values()[request.getBatch()]);
        tempSchedule.setCourse(CourseName.values()[request.getCourse()]);
        tempSchedule.setSection(SectionEnum.values()[request.getSection()]);
        tempSchedule.setDay(DayEnum.values()[request.getDay()]);
        tempSchedule.setLectures(request.getLectures());
        tempSchedule.setCode(generateScheduleCode(tempSchedule));

        return tempSchedule;
    }


}
