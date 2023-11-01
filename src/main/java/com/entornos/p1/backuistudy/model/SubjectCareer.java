package com.entornos.p1.backuistudy.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "subject_careers")
public class SubjectCareer implements Serializable {
    private static final long serialVersionUID = -1455252141965127122L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_subject", nullable = false)
    private Subject idSubject;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_career", nullable = false)
    private Career idCareer;


}