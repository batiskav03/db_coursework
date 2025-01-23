package com.senechka.course_back.services;

import com.senechka.course_back.DAO.TeamDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Mock
    private TeamDAO teamDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTeamPlayers() {
        String teamName = "Team1";
        String gameName = "Game1";

        when(teamDAO.callGetTeamPlayers(teamName, gameName)).thenReturn(List.of("Player1", "Player2"));

        List<String> players = teamService.getTeamPlayers(teamName, gameName);
        verify(teamDAO, times(1)).callGetTeamPlayers(teamName, gameName);
        assertEquals(List.of("Player1", "Player2"), players);
    }

    @Test
    void addTeam() {
        String name = "New Team";
        String game = "Game1";
        Integer ttl_win = 10;
        String region = "Region1";

        teamService.addTeam(name, game, ttl_win, region);
        verify(teamDAO, times(1)).callAddTeam(name, game, ttl_win, region);
    }

    @Test
    void deleteTeam() {
        Long teamId = 1L;

        ResponseEntity<Void> response = teamService.deleteTeam(teamId);
        // Здесь можно добавить логику для проверки удаления, если у вас есть соответствующий метод в DAO
        assertEquals(ResponseEntity.ok().build(), response);
    }
} 