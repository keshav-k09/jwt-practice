package com.example.jwt_practice.controller;
import com.example.jwt_practice.service.jwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class authController {
    private final jwtService js;
    public authController(jwtService js){
        this.js=js;
    }
    @PostMapping("/login")
    public String login(@RequestParam String username) {

        System.out.println("LOGIN CONTROLLER REACHED");

        return js.generateToken(username);
    }


}
