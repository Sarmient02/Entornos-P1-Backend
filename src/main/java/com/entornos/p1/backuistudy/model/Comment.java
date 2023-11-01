package com.entornos.p1.backuistudy.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = -6648546971746976208L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "body", length = Integer.MAX_VALUE)
    private String body;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "score")
    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_post", nullable = false)
    private Post idPost;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;

}