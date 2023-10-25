package com.entornos.p1.backuistudy.controller;

import com.entornos.p1.backuistudy.dto.JwtAuthenticationResponse;
import com.entornos.p1.backuistudy.dto.SignInRequestDTO;
import com.entornos.p1.backuistudy.dto.SignUpRequestDTO;
import com.entornos.p1.backuistudy.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;

    @PostMapping("/signup")
    public JwtAuthenticationResponse signup(@RequestBody SignUpRequestDTO request) {
        return authenticationService.signup(request);
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse signin(@RequestBody SignInRequestDTO request) {
        return authenticationService.signin(request);
    }

}
