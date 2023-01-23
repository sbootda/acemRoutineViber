package com.acem.demo.repository;

import com.acem.demo.entity.Schedule;
import com.acem.demo.entity.enums.CourseName;
import com.acem.demo.entity.enums.DayEnum;
import com.acem.demo.entity.enums.SectionEnum;
import com.acem.demo.entity.enums.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    Schedule getByBatchAndCourseAndDayAndSection(Year batch, CourseName course, DayEnum Day, SectionEnum Section);

}
