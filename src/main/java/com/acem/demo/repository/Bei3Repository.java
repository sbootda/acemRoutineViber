package com.acem.demo.repository;

import com.acem.demo.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bei3Repository extends JpaRepository<Schedule, Long> {
}
