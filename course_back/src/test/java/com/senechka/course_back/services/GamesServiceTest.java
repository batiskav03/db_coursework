package com.senechka.course_back.services;

import com.senechka.course_back.DAO.GamesDAO;
import com.senechka.course_back.Requests.AddGameRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class GamesServiceTest {

    @InjectMocks
    private GamesService gamesService;

    @Mock
    private GamesDAO gamesDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addGame() {
        String name = "New Game";
        String desc = "Game Description";

        gamesService.addGame(name, desc);
        verify(gamesDAO, times(1)).callAddGame(name, desc);
    }

    @Test
    void viewGames() {
        gamesService.viewGames();
        verify(gamesDAO, times(1)).callViewGames();
    }

    @Test
    void deleteGame() {
        Long gameId = 1L;

        gamesService.deleteGame(gameId);
        verify(gamesDAO, times(1)).callDeleteGame(gameId);
    }
} 