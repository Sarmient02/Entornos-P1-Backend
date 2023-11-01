package com.entornos.p1.backuistudy.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "career")
public class Career implements Serializable {
    private static final long serialVersionUID = -6225764162301638186L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "career_code", nullable = false, length = Integer.MAX_VALUE)
    private String careerCode;

    @OneToOne(mappedBy = "idCareer")
    private SubjectCareer subjectCareer;


}