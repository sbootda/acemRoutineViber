package com.acem.demo.entity;

import com.acem.demo.entity.enums.CourseName;
import com.acem.demo.entity.enums.Year;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BATCHES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Batch {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    private Year batch;

    @Column(name = "COURSE", nullable = false)
    @Enumerated(EnumType.STRING)
    @OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "batchCourseFK", referencedColumnName = "ID")
    @ToString.Exclude
    @Fetch(FetchMode.SUBSELECT)
    private List<Course> courses;
}
