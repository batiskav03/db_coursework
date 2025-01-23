package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.AddGameRequest;
import com.senechka.course_back.services.GamesService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class GamesController {
    private final GamesService gamesService;

    public GamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @PostMapping("/viewGames")
    public List<String> getGames(){
        return gamesService.viewGames();
    }

    @PostMapping("/addGame")
    public void addGame(@RequestBody AddGameRequest request) {
        gamesService.addGame(request.getName(), request.getDesc());
    }

    @DeleteMapping("/games/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        // Логика удаления игры по id
        return ResponseEntity.noContent().build();
    }
}
