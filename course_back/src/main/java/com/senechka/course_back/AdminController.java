package com.senechka.course_back;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/api/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminPanel() {
        return "Welcome to the Admin Panel!";
    }
} 