package com.senechka.course_back.services;

import com.senechka.course_back.DAO.TournamentsDAO;
import com.senechka.course_back.Requests.TournamentAddRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class TournamentsServiceTest {

    @InjectMocks
    private TournamentsService tournamentsService;

    @Mock
    private TournamentsDAO tournamentsDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addTournament() {
        String name = "New Tournament";
        String description = "Tournament Description";

        tournamentsService.addTournament(name, description);
        verify(tournamentsDAO, times(1)).callAddTournament(name, description);
    }

    @Test
    void viewTournaments() {
        tournamentsService.viewTournaments();
        verify(tournamentsDAO, times(1)).callViewTournaments();
    }

    @Test
    void deleteTournament() {
        Long tournamentId = 1L;

        tournamentsService.deleteTournament(tournamentId);
        verify(tournamentsDAO, times(1)).callDeleteTournament(tournamentId);
    }
} 