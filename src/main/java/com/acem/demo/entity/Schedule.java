package com.acem.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name ="BEI3")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Schedule {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DAY", length = 20)
    private String day;

    @Column(name="SECTION", length = 10)
    private String section;
}
