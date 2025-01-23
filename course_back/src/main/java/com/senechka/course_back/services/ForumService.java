package com.senechka.course_back.services;

import org.springframework.stereotype.Service;

@Service
public class ForumService {

    public void processForum(ForumRequest forumRequest) {
        // Логика обработки данных ФОРУМ
        System.out.println("Title: " + forumRequest.getTitle());
        System.out.println("Content: " + forumRequest.getContent());
    }
} 