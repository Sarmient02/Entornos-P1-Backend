package com.entornos.p1.backuistudy.service.impl;

import com.entornos.p1.backuistudy.dto.JwtAuthenticationResponse;
import com.entornos.p1.backuistudy.dto.SignInRequestDTO;
import com.entornos.p1.backuistudy.dto.SignUpRequestDTO;
import com.entornos.p1.backuistudy.model.Role;
import com.entornos.p1.backuistudy.model.User;
import com.entornos.p1.backuistudy.repository.IUserRepository;
import com.entornos.p1.backuistudy.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {

    private IUserRepository userRepository;

    private IUserService userService;

    private final PasswordEncoder passwordEncoder;

    private JwtServiceImpl jwtService;

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse signup(SignUpRequestDTO request) {
        var user = User
                .builder()
                .fullName(request.getFullName())
                .studentCode(request.getStudentCode())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        user = userService.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }


    public JwtAuthenticationResponse signin(SignInRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserService(@Qualifier("userServiceImpl") IUserService userService){
        this.userService = userService;
    }

    @Autowired
    public void setJwtService(@Qualifier("jwtServiceImpl") JwtServiceImpl jwtService){
        this.jwtService = jwtService;
    }

}
