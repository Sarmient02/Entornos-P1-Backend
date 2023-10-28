package com.entornos.p1.backuistudy.repository;

import com.entornos.p1.backuistudy.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

    @Query("FROM Post p WHERE p.title LIKE :title")
    List<Post> findByTitleLike(String title);
}
