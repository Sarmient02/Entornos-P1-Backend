package com.entornos.p1.backuistudy.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "follow")
public class Follow implements Serializable {
    private static final long serialVersionUID = 8397915488756440787L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_user_id")
    private User followingUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed_user_id")
    private User followedUser;

    @Column(name = "created_at")
    private Instant createdAt;

}