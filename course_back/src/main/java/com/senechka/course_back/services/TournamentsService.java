package com.senechka.course_back.services;

import com.senechka.course_back.entities.Tournament;
import com.senechka.course_back.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentsService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public void addTournament(String name, String description) {
        Tournament tournament = new Tournament();
        tournament.setName(name);
        tournament.setDescription(description);
        tournamentRepository.save(tournament);
    }

    public List<Tournament> viewTournaments() {
        return tournamentRepository.findAll();
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
}
