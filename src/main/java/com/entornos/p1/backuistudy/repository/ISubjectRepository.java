package com.entornos.p1.backuistudy.repository;

import com.entornos.p1.backuistudy.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long> {
}
