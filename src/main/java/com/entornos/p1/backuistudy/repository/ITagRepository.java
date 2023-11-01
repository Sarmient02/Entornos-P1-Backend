package com.entornos.p1.backuistudy.repository;

import com.entornos.p1.backuistudy.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT t FROM Tag t WHERE LOWER(t.name) = LOWER(:name)")
    Tag findTopByName(String name);
    //Tag findTopByNameByName(String name);
}
