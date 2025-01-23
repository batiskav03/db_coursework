package com.senechka.course_back.services;

import com.senechka.course_back.Requests.ForumResponseRequest;
import com.senechka.course_back.Requests.ForumReactionRequest;
import org.springframework.stereotype.Service;

@Service
public class ForumService {

    public void processForum(ForumRequest forumRequest) {
        // Логика обработки данных ФОРУМ
        System.out.println("Title: " + forumRequest.getTitle());
        System.out.println("Content: " + forumRequest.getContent());
    }

    public void processResponse(ForumResponseRequest responseRequest) {
        System.out.println("Forum ID: " + responseRequest.getForumId());
        System.out.println("Response Content: " + responseRequest.getResponseContent());
    }

    public void processReaction(ForumReactionRequest reactionRequest) {
        System.out.println("Forum ID: " + reactionRequest.getForumId());
        System.out.println("Reaction Type: " + reactionRequest.getReactionType());
    }
} 