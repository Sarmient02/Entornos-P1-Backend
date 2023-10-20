package com.entornos.p1.backuistudy.repository;

import com.entornos.p1.backuistudy.model.TestUsers;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestUsersRepository extends JpaRepository<TestUsers, Long> {

}
