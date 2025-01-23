package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.PlayerAddRequest;
import com.senechka.course_back.services.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addPlayer() {
        PlayerAddRequest playerAddRequest = new PlayerAddRequest();
        playerAddRequest.setName("New Player");
        playerAddRequest.setTeam("Team1");

        ResponseEntity<Void> response = playerController.addPlayer(playerAddRequest);
        verify(playerService, times(1)).addPlayer("New Player", "Team1");
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void viewPlayers() {
        when(playerService.viewPlayers()).thenReturn(List.of("Player1", "Player2"));

        List<String> players = playerController.viewPlayers();
        verify(playerService, times(1)).viewPlayers();
        assertEquals(List.of("Player1", "Player2"), players);
    }

    @Test
    void deletePlayer() {
        Long playerId = 1L;

        ResponseEntity<Void> response = playerController.deletePlayer(playerId);
        verify(playerService, times(1)).deletePlayer(playerId);
        assertEquals(ResponseEntity.ok().build(), response);
    }
} 