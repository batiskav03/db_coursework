package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.TeamAddRequest;
import com.senechka.course_back.Requests.TeamRequest;
import com.senechka.course_back.services.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamControllerTest {

    @InjectMocks
    private TeamController teamController;

    @Mock
    private TeamService teamService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTeamPlayers() {
        TeamRequest teamRequest = new TeamRequest();
        teamRequest.setParam1("Team1");
        teamRequest.setParam2("Game1");

        when(teamService.getTeamPlayers("Team1", "Game1")).thenReturn(List.of("Player1", "Player2"));

        List<String> players = teamController.getTeamPlayers(teamRequest);
        verify(teamService, times(1)).getTeamPlayers("Team1", "Game1");
        assertEquals(List.of("Player1", "Player2"), players);
    }

    @Test
    void addTeam() {
        TeamAddRequest teamAddRequest = new TeamAddRequest();
        teamAddRequest.setName("New Team");
        teamAddRequest.setGame("Game1");
        teamAddRequest.setTtl_win(10);
        teamAddRequest.setRegion("Region1");

        ResponseEntity<Void> response = teamController.addTeam(teamAddRequest);
        verify(teamService, times(1)).addTeam("New Team", "Game1", 10, "Region1");
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void deleteItem() {
        Long teamId = 1L;

        ResponseEntity<Void> response = teamController.deleteItem(teamId);
        verify(teamService, times(1)).deleteTeam(teamId);
        assertEquals(ResponseEntity.ok().build(), response);
    }
} 