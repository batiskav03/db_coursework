package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.PlayerAddRequest;
import com.senechka.course_back.Requests.PlayerDeleteRequest;
import com.senechka.course_back.Requests.TeamRequest;
import com.senechka.course_back.Requests.TeamsByGameRequest;
import com.senechka.course_back.services.PlayerService;
import com.senechka.course_back.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;


    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Void> addPlayer(@RequestBody PlayerAddRequest playerAddRequest) {
        playerService.addPlayer(playerAddRequest.getName(), playerAddRequest.getTeam());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<String> viewPlayers() {
        return playerService.viewPlayers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok().build();
    }
}


