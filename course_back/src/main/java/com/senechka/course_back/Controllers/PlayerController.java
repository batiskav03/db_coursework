package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.PlayerAddRequest;
import com.senechka.course_back.Requests.PlayerDeleteRequest;
import com.senechka.course_back.Requests.TeamRequest;
import com.senechka.course_back.Requests.TeamsByGameRequest;
import com.senechka.course_back.services.PlayerService;
import com.senechka.course_back.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class PlayerController {

    private final PlayerService playerService;


    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/deletePlayer")
    public void getTeamPlayers(@RequestBody PlayerDeleteRequest request) {
        playerService.deletePlayer(request.getNickname());
    }

    @PostMapping("/addPlayer")
    public void addPlayer(@RequestBody PlayerAddRequest request) {

        System.out.println(request.getTeamName());
        playerService.addPlayer(request.getNickname(), request.getFirstName(),
                request.getSurname(), request.getBirthDay(), request.getTtlWin(),
                request.getTeamName(), request.getPlayerCountry());
    }
    @PostMapping("/viewPlayers")
    public List<String> viewPlayers(){
        return playerService.viewPlayers();
    }
}


