package com.entornos.p1.backuistudy.controller;

import com.entornos.p1.backuistudy.model.TestUsers;
import com.entornos.p1.backuistudy.service.impl.PruebaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prueba")
public class PruebaController {
    @Autowired
    private PruebaServiceImpl testUserService;

    @GetMapping("/datos")
    //@PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<TestUsers> getAllUsers() {
        return testUserService.getAllUsers();
    }

}
