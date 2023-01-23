package com.acem.demo.request;

import com.acem.demo.entity.Lecture;
import com.acem.demo.entity.Schedule;
import com.acem.demo.entity.enums.CourseName;
import com.acem.demo.entity.enums.DayEnum;
import com.acem.demo.entity.enums.SectionEnum;
import com.acem.demo.entity.enums.Year;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequest {
    private Integer batch;
    private Integer course;
    private Integer section;
    private Integer day;
    private List<Lecture> lectures;
}
