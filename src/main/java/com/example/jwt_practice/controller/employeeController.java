package com.example.jwt_practice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class employeeController {

    @GetMapping("/{username}")
    @PreAuthorize(
            "hasRole('ADMIN') or " +
                    "@employeeService.isOwner(#username, authentication.name)"
    )
    public String getEmployee(@PathVariable String username) {
        return "Employee record for: " + username;
    }
}
