package com.senechka.course_back.services;

import com.senechka.course_back.DAO.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
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
}