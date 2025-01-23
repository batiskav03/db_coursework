package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.AddGameRequest;
import com.senechka.course_back.services.GamesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GamesControllerTest {

    @InjectMocks
    private GamesController gamesController;

    @Mock
    private GamesService gamesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addGame() {
        AddGameRequest addGameRequest = new AddGameRequest();
        addGameRequest.setName("New Game");
        addGameRequest.setDesc("Game Description");

        ResponseEntity<Void> response = gamesController.addGame(addGameRequest);
        verify(gamesService, times(1)).addGame("New Game", "Game Description");
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void viewGames() {
        when(gamesService.viewGames()).thenReturn(List.of("Game1", "Game2"));

        List<String> games = gamesController.getGames();
        verify(gamesService, times(1)).viewGames();
        assertEquals(List.of("Game1", "Game2"), games);
    }

    @Test
    void deleteGame() {
        Long gameId = 1L;

        ResponseEntity<Void> response = gamesController.deleteGame(gameId);
        verify(gamesService, times(1)).deleteGame(gameId);
        assertEquals(ResponseEntity.ok().build(), response);
    }
} 