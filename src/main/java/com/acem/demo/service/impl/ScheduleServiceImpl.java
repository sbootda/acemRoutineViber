package com.acem.demo.service.impl;

import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.entity.Lecture;
import com.acem.demo.entity.Schedule;
import com.acem.demo.repository.LectureRepository;
import com.acem.demo.repository.ScheduleRepository;
import com.acem.demo.response.LectureResponse;
import com.acem.demo.response.Response;
import com.acem.demo.response.ScheduleResponse;
import com.acem.demo.service.ScheduleService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Response get(Schedule schedule) {
        try{
            Schedule getSchedule= scheduleRepository.getByBatchAndCourseAndDayAndSection(
                    schedule.getBatch(),
                    schedule.getCourse(),
                    schedule.getDay(),
                    schedule.getSection()
            );
            ScheduleResponse scheduleResponse = mapToScheduleResponse(getSchedule);
            return new Response()
                    .statusCode(HttpServletResponse.SC_OK)
                    .description(ResponseMessageConstant.Batch.FOUND)
                    .success(true)
                    .data(scheduleResponse);
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
            ScheduleResponse scheduleResponse = mapToScheduleResponse(savedSchedule);
            return new Response()
                    .statusCode(HttpServletResponse.SC_OK)
                    .description(ResponseMessageConstant.Batch.SAVED)
                    .success(true)
                    .data(scheduleResponse);
        }catch (Exception ex){
            System.out.println("Exception: "+ex.getMessage());
            return new Response()
                    .statusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .description(ResponseMessageConstant.Batch.NOT_SAVED)
                    .success(false);
        }
    }

    public ScheduleResponse mapToScheduleResponse(Schedule schedule){
        ScheduleResponse scheduleResponse = new ScheduleResponse();
        List<LectureResponse> lectureResponseList = new ArrayList<>();
        List<Lecture> lectures = schedule.getLectures();
        for (Lecture lecture :
                lectures) {
            lectureResponseList.add(mapToLectureResponse(lecture));
        }
        scheduleResponse.batch(schedule.getBatch().ordinal())
                .course(schedule.getCourse().ordinal())
                .section(schedule.getSection().ordinal())
                .day(schedule.getDay().ordinal())
                .lectures(lectureResponseList);
            return scheduleResponse;
    }

    public LectureResponse mapToLectureResponse(Lecture lecture){
        return new LectureResponse(lecture.getName(),
                    lecture.getStartTime(),
                    lecture.getEndTime(),
                    lecture.getGroup().name());
    }
}
