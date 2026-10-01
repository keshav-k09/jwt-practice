package com.example.jwt_practice.service;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;

@Service
public class jwtService {

    @Value("${jwt.secret}")
    private String secretKey;
    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(
                secretKey.getBytes(StandardCharsets.UTF_8)
        );

    }
    public String generateToken(String username){
        return Jwts.builder().subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(getSigningKey())
                .compact();
    }
}
