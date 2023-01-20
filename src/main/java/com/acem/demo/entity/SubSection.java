package com.acem.demo.entity;

import com.acem.demo.entity.enums.DayEnum;
import com.acem.demo.entity.enums.SubSectionEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUBSECTIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubSection {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    private SubSectionEnum subSection;

    @Column(name = "DAY", nullable = false)
    @Enumerated(EnumType.STRING)
    @OneToMany(targetEntity = DaySchedule.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "subsectionDayScheduleFK", referencedColumnName = "ID")
    @ToString.Exclude
    private List<DaySchedule> daySchedules;
}
