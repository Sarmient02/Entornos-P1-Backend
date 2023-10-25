package com.entornos.p1.backuistudy.service.interfaces;

import com.entornos.p1.backuistudy.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public UserDetailsService userDetailsService();

    public User save(User newUser);

}
