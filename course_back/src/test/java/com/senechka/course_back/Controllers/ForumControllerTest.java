package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.ForumRequest;
import com.senechka.course_back.Requests.ForumResponseRequest;
import com.senechka.course_back.Requests.ForumReactionRequest;
import com.senechka.course_back.services.ForumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class ForumControllerTest {

    @InjectMocks
    private ForumController forumController;

    @Mock
    private ForumService forumService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void submitForum() {
        ForumRequest forumRequest = new ForumRequest();
        forumRequest.setTitle("Test Title");
        forumRequest.setContent("Test Content");

        ResponseEntity<Void> response = forumController.submitForum(forumRequest);
        verify(forumService, times(1)).processForum(forumRequest);
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void submitResponse() {
        ForumResponseRequest responseRequest = new ForumResponseRequest();
        responseRequest.setForumId(1L);
        responseRequest.setResponseContent("Test Response");

        ResponseEntity<Void> response = forumController.submitResponse(responseRequest);
        verify(forumService, times(1)).processResponse(responseRequest);
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void submitReaction() {
        ForumReactionRequest reactionRequest = new ForumReactionRequest();
        reactionRequest.setForumId(1L);
        reactionRequest.setReactionType("like");

        ResponseEntity<Void> response = forumController.submitReaction(reactionRequest);
        verify(forumService, times(1)).processReaction(reactionRequest);
        assertEquals(ResponseEntity.ok().build(), response);
    }
} 