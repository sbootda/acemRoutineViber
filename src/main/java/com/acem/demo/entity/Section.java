package com.acem.demo.entity;

import com.acem.demo.entity.enums.CourseName;
import com.acem.demo.entity.enums.SectionEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SECTIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Section {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    private SectionEnum section;

    @Column(name = "SUB_SECTION", columnDefinition = "VARCHAR(50) DEFAULT 'BOTH'", nullable = false)
    @Enumerated(EnumType.STRING)
    @OneToMany(targetEntity = SubSection.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sectionSubSectionFK", referencedColumnName = "ID")
    @ToString.Exclude
    private List<SubSection> subSections;
}
