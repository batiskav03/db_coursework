package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.TeamAddRequest;
import com.senechka.course_back.Requests.TeamRequest;
import com.senechka.course_back.Requests.TeamsByGameRequest;
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
public class TeamController {

    private final TeamService teamService;


    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/getTeamPlayers")
    public List<String> getTeamPlayers(@RequestBody TeamRequest request) {
        return teamService.getTeamPlayers(request.getParam1(), request.getParam2());
    }

    @PostMapping("/getTeamsByGame")
    public List<String> getTeamsByGame(@RequestBody TeamsByGameRequest request) {
        return teamService.getTeamsByGame(request.getGameName());
    }

    @PostMapping("/addTeam")
    public void addTeam(@RequestBody TeamAddRequest request) {
        teamService.addTeam(request.getName(), request.getGame(), request.getTtl_win(), request.getRegion());
    }
}
