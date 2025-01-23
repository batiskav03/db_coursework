package com.senechka.course_back;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        String role = "USER";
        if ("admin".equals(authRequest.getUsername())) {
            role = "ADMIN";
        }

        String token = Jwts.builder()
                .setSubject(authRequest.getUsername())
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS512, "your_secret_key")
                .compact();
        return token;
    }

    @DeleteMapping("/auth/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // Логика удаления пользователя по id
        return ResponseEntity.noContent().build();
    }
} 