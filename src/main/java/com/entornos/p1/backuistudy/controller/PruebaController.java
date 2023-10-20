package com.entornos.p1.backuistudy.controller;

import com.entornos.p1.backuistudy.model.TestUsers;
import com.entornos.p1.backuistudy.service.impl.PruebaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prueba")
@CrossOrigin(origins = {"https://entornos-p1-frontend.onrender.com", "http://127.0.0.1:5501/"})
public class PruebaController {
    @Autowired
    private PruebaServiceImpl testUserService;

    @GetMapping("/datos")
    public List<TestUsers> getAllUsers() {
        return testUserService.getAllUsers();
    }

}
