package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.TournamentAddRequest;
import com.senechka.course_back.services.TournamentsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TournamentsControllerTest {

    @InjectMocks
    private TournamentsController tournamentsController;

    @Mock
    private TournamentsService tournamentsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addTournament() {
        TournamentAddRequest tournamentAddRequest = new TournamentAddRequest();
        tournamentAddRequest.setName("New Tournament");
        tournamentAddRequest.setDescription("Tournament Description");

        ResponseEntity<Void> response = tournamentsController.addTournament(tournamentAddRequest);
        verify(tournamentsService, times(1)).addTournament("New Tournament", "Tournament Description");
        assertEquals(ResponseEntity.ok().build(), response);
    }

    @Test
    void viewTournaments() {
        when(tournamentsService.viewTournaments()).thenReturn(List.of("Tournament1", "Tournament2"));

        List<String> tournaments = tournamentsController.viewTournaments();
        verify(tournamentsService, times(1)).viewTournaments();
        assertEquals(List.of("Tournament1", "Tournament2"), tournaments);
    }

    @Test
    void deleteTournament() {
        Long tournamentId = 1L;

        ResponseEntity<Void> response = tournamentsController.deleteTournament(tournamentId);
        verify(tournamentsService, times(1)).deleteTournament(tournamentId);
        assertEquals(ResponseEntity.ok().build(), response);
    }
} 