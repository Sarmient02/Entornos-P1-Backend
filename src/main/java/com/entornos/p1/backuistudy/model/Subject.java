package com.entornos.p1.backuistudy.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    private static final long serialVersionUID = -6719407749632392L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "career_id", nullable = false)
    private Integer careerId;

    @OneToMany(mappedBy = "subject")
    private List<Post> posts;

    @OneToOne(mappedBy = "idSubject")
    private SubjectCareer subjectCareer;


}