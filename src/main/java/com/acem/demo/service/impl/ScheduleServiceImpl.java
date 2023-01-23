package com.acem.demo.service.impl;

import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.entity.Lecture;
import com.acem.demo.entity.Schedule;
import com.acem.demo.repository.LectureRepository;
import com.acem.demo.repository.ScheduleRepository;
import com.acem.demo.response.Response;
import com.acem.demo.service.ScheduleService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final LectureRepository lectureRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(LectureRepository lectureRepository, ScheduleRepository scheduleRepository) {
        this.lectureRepository = lectureRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Response getLectures(Schedule schedule) {
        try{
            Schedule tempSchedule= scheduleRepository.getByBatchAndCourseAndDayAndSection(
                    schedule.getBatch(),
                    schedule.getCourse(),
                    schedule.getDay(),
                    schedule.getSection()
            );
            List<Lecture> lectureList = lectureRepository.getLectures(tempSchedule.getId());
            return new Response()
                    .statusCode(HttpServletResponse.SC_OK)
                    .description(ResponseMessageConstant.Batch.FOUND)
                    .success(true)
                    .data(lectureList);
        }catch (Exception ex){
            System.out.println("Exception: "+ex.getMessage());
            return new Response()
                    .statusCode(HttpServletResponse.SC_NOT_FOUND)
                    .description(ResponseMessageConstant.Batch.NOT_FOUND)
                    .success(false);
        }
    }

    @Override
    public Response save(Schedule schedule) {
        try{
            Schedule savedSchedule = scheduleRepository.save(schedule);
            return new Response()
                    .statusCode(HttpServletResponse.SC_OK)
                    .description(ResponseMessageConstant.Batch.SAVED)
                    .success(true).data(savedSchedule);
        }catch (Exception ex){
            System.out.println("Exception: "+ex.getMessage());
            return new Response()
                    .statusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .description(ResponseMessageConstant.Batch.NOT_SAVED)
                    .success(false);
        }
    }



}
