package com.senechka.course_back.services;

import com.senechka.course_back.Requests.ForumRequest;
import com.senechka.course_back.Requests.ForumResponseRequest;
import com.senechka.course_back.Requests.ForumReactionRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForumServiceTest {

    private final ForumService forumService = new ForumService();

    @Test
    void processForum() {
        ForumRequest forumRequest = new ForumRequest();
        forumRequest.setTitle("Test Title");
        forumRequest.setContent("Test Content");

        forumService.processForum(forumRequest);
        // Здесь можно добавить проверки, если вы сохраняете данные в базе данных
    }

    @Test
    void processResponse() {
        ForumResponseRequest responseRequest = new ForumResponseRequest();
        responseRequest.setForumId(1L);
        responseRequest.setResponseContent("Test Response");

        forumService.processResponse(responseRequest);
        // Здесь можно добавить проверки, если вы сохраняете данные в базе данных
    }

    @Test
    void processReaction() {
        ForumReactionRequest reactionRequest = new ForumReactionRequest();
        reactionRequest.setForumId(1L);
        reactionRequest.setReactionType("like");

        forumService.processReaction(reactionRequest);
        // Здесь можно добавить проверки, если вы сохраняете данные в базе данных
    }
} 