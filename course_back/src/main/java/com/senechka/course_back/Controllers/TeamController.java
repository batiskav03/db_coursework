package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.TeamRequest;
import com.senechka.course_back.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
        // Вызываем сервисный метод для получения данных из базы данных
        return teamService.getTeamPlayers(request.getParam1(), request.getParam2());
    }

    // Другие методы контрроллера, если необходимо
}
