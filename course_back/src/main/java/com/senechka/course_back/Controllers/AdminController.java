package com.senechka.course_back.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminPanel() {
        return "Welcome to the Admin Panel!";
    }

    @DeleteMapping("/admin/items/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAdminItem(@PathVariable Long id) {
        // Логика удаления элемента админской панели по id
        return ResponseEntity.noContent().build();
    }
} 