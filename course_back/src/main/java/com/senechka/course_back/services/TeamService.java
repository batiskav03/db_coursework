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

    public List<String> getTeamPlayers(String param1, String param2) {
        // Вызываем метод в DAO, который возвращает массив данных из базы данных
        return teamDAO.callGetTeamPlayers(param1, param2);
    }

    // Другие методы для вызова ваших функций
}