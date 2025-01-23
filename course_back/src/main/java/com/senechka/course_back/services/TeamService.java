package com.senechka.course_back.services;

import com.senechka.course_back.DAO.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamDAO teamDAO;

    @Autowired
    public TeamService(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public List<String> getTeamPlayers(String teamName, String gameName) {
        return teamDAO.callGetTeamPlayers(teamName, gameName);
    }

    public List<String> getTeamsByGame(String gameName) {
        return teamDAO.callGetTeamNamesByGame(gameName);
    }

    public void addTeam(String name, String game, Integer ttl_win, String region) {
        teamDAO.callAddTeam(name, game, ttl_win, region);
    }

    public ResponseEntity<Void> deleteTeam(Long id) {
        // Логика удаления команды по id
        return ResponseEntity.ok().build();
    }
}