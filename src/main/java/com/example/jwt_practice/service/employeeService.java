package com.example.jwt_practice.service;
import org.springframework.stereotype.Service;
@Service("employeeService")
public class employeeService {
    public boolean isOwner(String requestedUsername,
                           String authenticatedUsername) {

        return requestedUsername.equals(authenticatedUsername);
    }
}

