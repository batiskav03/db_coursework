package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.ForumRequest;
import com.senechka.course_back.services.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ForumController {

    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @PostMapping("/forum")
    public ResponseEntity<Void> submitForum(@RequestBody ForumRequest forumRequest) {
        forumService.processForum(forumRequest);
        return ResponseEntity.ok().build();
    }
} 