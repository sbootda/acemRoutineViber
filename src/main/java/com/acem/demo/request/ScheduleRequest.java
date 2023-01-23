package com.acem.demo.request;

import com.acem.demo.entity.Schedule;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequest {
    private Schedule schedule;
}
