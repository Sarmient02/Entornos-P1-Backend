package com.entornos.p1.backuistudy.repository;

import com.entornos.p1.backuistudy.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {
}
