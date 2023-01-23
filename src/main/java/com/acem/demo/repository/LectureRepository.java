package com.acem.demo.repository;

import com.acem.demo.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    @Query(
            value = "SELECT * FROM LECTURES l WHERE l.SCHEDULE_ID=?1",
            nativeQuery = true)
    List<Lecture> getLectures(Long scheduleId);

}
