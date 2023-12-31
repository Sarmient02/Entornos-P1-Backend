package com.entornos.p1.backuistudy.service.impl;

import com.entornos.p1.backuistudy.dto.EditUserRequestDTO;
import com.entornos.p1.backuistudy.dto.UserDataDTO;
import com.entornos.p1.backuistudy.model.Role;
import com.entornos.p1.backuistudy.model.User;
import com.entornos.p1.backuistudy.repository.IUserRepository;
import com.entornos.p1.backuistudy.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public User loadUserByUsername(String username) {
                return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    public List<User> findAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public User save(User newUser) {
        if (newUser.getId() == null){
            newUser.setCreatedAt(LocalDateTime.now());
        }else{
            newUser.setUpdatedAt(LocalDateTime.now());
            userRepository.editUser(newUser.getUsername(), newUser.getFullName(), newUser.getStudentCode(), newUser.getEmail(), newUser.getUpdatedAt(), newUser.getPassword(), newUser.getId());;
        }
        return userRepository.save(newUser);
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserDataDTO getUserData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserDataDTO userDataDTO = new UserDataDTO();
        userDataDTO.setUsername(userDetails.getUsername());
        userDataDTO.setRole(userDetails.getAuthorities().toArray()[0].toString());
        userRepository.findByUsername(userDetails.getUsername()).ifPresent(user -> {
            userDataDTO.setFullName(user.getFullName());
            userDataDTO.setId(user.getId());
        });
        return userDataDTO;
    }

    public boolean edit(EditUserRequestDTO editedUser) {
        Optional<User> oldUser = userRepository.findById(editedUser.getId());
        if (oldUser.isPresent()){
            if(editedUser.getPassword().isEmpty() || editedUser.getPassword() == null){
                editedUser.setPassword(oldUser.get().getPassword());
            }else{
                editedUser.setPassword(passwordEncoder.encode(editedUser.getPassword()));
            }
            User user = User
                    .builder()
                    .id(editedUser.getId())
                    .fullName(editedUser.getFullName())
                    .studentCode(editedUser.getStudentCode())
                    .email(editedUser.getEmail())
                    .username(editedUser.getUsername())
                    .password(editedUser.getPassword())
                    .role(Role.valueOf(editedUser.getRole()))
                    .build();
            this.save(user);
            return true;
        }
        return false;
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
