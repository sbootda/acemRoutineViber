package com.acem.demo.repository;

import com.acem.demo.entity.SubSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubSectionRepository extends JpaRepository<SubSection, Long> {
}
