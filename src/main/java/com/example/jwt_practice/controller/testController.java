package com.example.jwt_practice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class testController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user() {
        return "USER endpoint accessed";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String manager() {
        return "MANAGER endpoint accessed";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "ADMIN endpoint accessed";
    }
    @GetMapping("/manage")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public String manage() {
        return "ADMIN or MANAGER can access this";
    }
}