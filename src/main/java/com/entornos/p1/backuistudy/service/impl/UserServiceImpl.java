package com.entornos.p1.backuistudy.service.impl;

import com.entornos.p1.backuistudy.model.User;
import com.entornos.p1.backuistudy.repository.IUserRepository;
import com.entornos.p1.backuistudy.security.SecurityUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl {

    private IUserRepository userRepository;

    public Optional<User> getUserWithAuthorities(){
        return SecurityUtils.getCurrentUsername().flatMap(username -> userRepository.findByUsername(username));
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
