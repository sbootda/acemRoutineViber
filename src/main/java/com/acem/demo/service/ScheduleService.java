package com.acem.demo.service;

import com.acem.demo.entity.Schedule;
import com.acem.demo.response.Response;

public interface ScheduleService {

    Response getLectures(Schedule schedule);
    Response save(Schedule schedule);

}
