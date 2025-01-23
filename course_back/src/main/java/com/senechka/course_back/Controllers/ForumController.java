package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.ForumRequest;
import com.senechka.course_back.Requests.ForumResponseRequest;
import com.senechka.course_back.Requests.ForumReactionRequest;
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

    @PostMapping("/forum/response")
    public ResponseEntity<Void> submitResponse(@RequestBody ForumResponseRequest responseRequest) {
        forumService.processResponse(responseRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/forum/reaction")
    public ResponseEntity<Void> submitReaction(@RequestBody ForumReactionRequest reactionRequest) {
        forumService.processReaction(reactionRequest);
        return ResponseEntity.ok().build();
    }
} 