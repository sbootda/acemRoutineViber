package com.acem.demo.entity;

import com.acem.demo.entity.enums.DayEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DAY_SCHEDULES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DaySchedule {

        @Id
        @Column(name="ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "NAME", nullable = false)
        @Enumerated(EnumType.STRING)
        private DayEnum day;

        @Column(name = "PERIOD", nullable = false)
        @Enumerated(EnumType.STRING)
        @OneToMany(targetEntity = Period.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name = "dayschedulePeriodFK", referencedColumnName = "ID")
        @ToString.Exclude
        private List<Period> periods;
}
