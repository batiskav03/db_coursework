package com.senechka.course_back;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AuthController {

    @PostMapping("/api/login")
    public String login(@RequestBody AuthRequest authRequest) {
        // Здесь вы должны проверить имя пользователя и пароль
        // Если проверка успешна, создайте JWT
        String token = Jwts.builder()
                .setSubject(authRequest.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Токен действителен 1 день
                .signWith(SignatureAlgorithm.HS512, "your_secret_key")
                .compact();
        return token;
    }
} 