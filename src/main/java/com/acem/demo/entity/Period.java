package com.acem.demo.entity;

import com.acem.demo.entity.enums.CourseName;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PERIODS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Period {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="START_TIME", length = 200)
    private String startTime;

    @Column(name="END_TIME", length = 200)
    private String endTime;

    @Column(name="PERIOD", length = 200)
    private String period;
}
