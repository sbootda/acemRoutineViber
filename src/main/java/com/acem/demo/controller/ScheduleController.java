package com.acem.demo.controller;

import com.acem.demo.repository.ScheduleRepository;
import com.acem.demo.request.ScheduleRequest;
import com.acem.demo.response.Response;
import com.acem.demo.service.ScheduleService;
import org.springframework.http.HttpRequest;
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
        return scheduleService.getLectures(request.getSchedule());
    }

    @PostMapping
    public Response save(@Validated @RequestBody ScheduleRequest request){
        return scheduleService.save(request.getSchedule());
    }
}
