package com.entornos.p1.backuistudy.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "file")
public class File implements Serializable {
    private static final long serialVersionUID = 7126552015401186157L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "size")
    private Double size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_type")
    private FileType fileType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post")
    private Post idPost;


}