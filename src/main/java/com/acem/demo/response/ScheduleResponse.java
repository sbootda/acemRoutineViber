package com.acem.demo.response;

import com.acem.demo.entity.Lecture;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse implements Serializable {
    private Integer batch;
    private Integer course;
    private Integer section;
    private Integer day;
    private List<LectureResponse> lectures;

    public ScheduleResponse batch(Integer batch) {
        this.batch = batch;
        return this;
    }

    public ScheduleResponse course(Integer course) {
        this.course = course;
        return this;

    }

    public ScheduleResponse section(Integer section) {
        this.section = section;
        return this;

    }

    public ScheduleResponse day(Integer day) {
        this.day = day;
        return this;
    }

    public ScheduleResponse lectures(List<LectureResponse> lectures) {
        this.lectures = lectures;
        return this;
    }
}

