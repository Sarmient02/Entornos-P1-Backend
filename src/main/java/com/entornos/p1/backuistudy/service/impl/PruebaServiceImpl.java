package com.entornos.p1.backuistudy.service.impl;

import com.entornos.p1.backuistudy.model.TestUsers;
import com.entornos.p1.backuistudy.repository.ITestUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaServiceImpl {

    private ITestUsersRepository testUserRepository;

    public List<TestUsers> getAllUsers() {
        return testUserRepository.findAll();
    }

    @Autowired
    public void setTestUserRepository(ITestUsersRepository testUserRepository) {
        this.testUserRepository = testUserRepository;
    }
}
