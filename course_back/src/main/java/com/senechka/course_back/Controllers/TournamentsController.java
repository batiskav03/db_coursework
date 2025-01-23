package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.TournamentAddRequest;
import com.senechka.course_back.services.TournamentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentsController {
    @Autowired
    private TournamentsService tournamentsService;

    @PostMapping
    public ResponseEntity<Void> addTournament(@RequestBody TournamentAddRequest tournamentAddRequest) {
        tournamentsService.addTournament(tournamentAddRequest.getName(), tournamentAddRequest.getDescription());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<String> viewTournaments() {
        return tournamentsService.viewTournaments();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
        tournamentsService.deleteTournament(id);
        return ResponseEntity.ok().build();
    }
}