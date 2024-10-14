package com.company.classworkrelationhomework.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.Timer;

@Slf4j
@Component
@RequiredArgsConstructor
public final class BaseJwtService {

    private SecretKey key;

    @Value("${spring.security.jwt-secret-key}")
    private String jwtSecretKey;

    @PostConstruct
    public void init() {
        byte[] keyBytes;
        keyBytes = Decoders.BASE64.decode(jwtSecretKey);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .requireIssuer("http://localhost:8080/")
                .build()
                .parseSignedClaims(token);
    }

    public String generateToken(String email, Map<String, Object> extraClaims) {
        return generateToken(extraClaims, email);
    }

    private String generateToken(Map<String, Object> map, String email) {
        long jwtTokenTime = 360000000;
        return Jwts
                .builder()
                .signWith(key)
                .claims()
                .issuedAt(new Date(System.currentTimeMillis()))
                .issuer("http://localhost:8080/")
                .add(map)
                .subject(email)
                .expiration(new Date(System.currentTimeMillis() + jwtTokenTime))
                .and().compact();
    }

}
