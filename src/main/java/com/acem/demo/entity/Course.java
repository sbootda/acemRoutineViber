package com.acem.demo.entity;

import com.acem.demo.entity.enums.CourseName;
import com.acem.demo.entity.enums.SectionEnum;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseName course;

    @Column(name = "SECTION", nullable = false)
    @Enumerated(EnumType.STRING)
    @OneToMany(targetEntity = Section.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "courseSectionFK", referencedColumnName = "ID")
    @ToString.Exclude
    @Fetch(FetchMode.SUBSELECT)
    private List<Section> sections;
}
