package com.entornos.p1.backuistudy.service.interfaces;

import com.entornos.p1.backuistudy.dto.EditUserRequestDTO;
import com.entornos.p1.backuistudy.dto.UserDataDTO;
import com.entornos.p1.backuistudy.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    public UserDetailsService userDetailsService();

    public List<User> findAll();

    public User save(User newUser);

    public void delete(Long id);

    public boolean edit(EditUserRequestDTO editedUser);

    public UserDataDTO getUserData();

}
