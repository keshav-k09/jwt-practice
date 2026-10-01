package com.example.jwt_practice.controller;


import com.example.jwt_practice.service.jwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class testController {

    @GetMapping("/hello")
    public String hello(){
        return "HELLO";
    }
}
