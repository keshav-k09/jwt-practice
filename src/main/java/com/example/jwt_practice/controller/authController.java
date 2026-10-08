
package com.example.jwt_practice.controller;

import com.example.jwt_practice.service.jwtService;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class authController {

    private final jwtService js;

    private final AuthenticationManager authenticationManager;
    public authController(jwtService js,AuthenticationManager authenticationManager) {
        this.js = js;
        this.authenticationManager=authenticationManager;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password) {
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));


        return js.generateToken(username);
    }
}
