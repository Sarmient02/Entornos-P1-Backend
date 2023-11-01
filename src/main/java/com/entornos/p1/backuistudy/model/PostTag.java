package com.entornos.p1.backuistudy.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "post_tags")
public class PostTag implements Serializable {
    private static final long serialVersionUID = -8968986580277637110L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_post", nullable = false)
    private Post idPost;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tag", nullable = false)
    private Tag idTag;

}