package com.acem.demo.entity;

import com.acem.demo.entity.enums.CourseName;
import com.acem.demo.entity.enums.DayEnum;
import com.acem.demo.entity.enums.SectionEnum;
import com.acem.demo.entity.enums.Year;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SCHEDULES")
public class Schedule {

    @Id
    @Column(name="ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BATCH", nullable = false)
    @Enumerated(EnumType.STRING)
    private Year batch;

    @Column(name = "COURSE", nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseName course;

    @Column(name = "SECTION", nullable = false)
    @Enumerated(EnumType.STRING)
    private SectionEnum section;

    @Column(name = "DAY", nullable = false)
    @Enumerated(EnumType.STRING)
    private DayEnum day;

    @OneToMany(targetEntity = Lecture.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_ID", referencedColumnName = "ID")
    @Fetch(FetchMode.SUBSELECT)
    private List<Lecture> lectures;
}

