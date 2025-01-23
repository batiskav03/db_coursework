package com.senechka.course_back.services;

import com.senechka.course_back.DAO.PlayerDAO;
import com.senechka.course_back.Requests.PlayerAddRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerDAO playerDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addPlayer() {
        String name = "New Player";
        String team = "Team1";

        playerService.addPlayer(name, team);
        verify(playerDAO, times(1)).callAddPlayer(name, team);
    }

    @Test
    void viewPlayers() {
        playerService.viewPlayers();
        verify(playerDAO, times(1)).callViewPlayers();
    }

    @Test
    void deletePlayer() {
        Long playerId = 1L;

        playerService.deletePlayer(playerId);
        verify(playerDAO, times(1)).callDeletePlayer(playerId);
    }
} 