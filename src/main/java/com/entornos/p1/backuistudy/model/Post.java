package com.entornos.p1.backuistudy.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "post")
public class Post implements Serializable {
    private static final long serialVersionUID = 8416044153824134323L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "created_at")
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "idPost")
    private List<Comment> comments;

    @OneToMany(mappedBy = "idPost")
    private List<File> files;

    @OneToOne(mappedBy = "idPost")
    private PostTag postTag;

}