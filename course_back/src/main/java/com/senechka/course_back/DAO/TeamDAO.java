package com.senechka.course_back.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TeamDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> callGetTeamPlayers(String teamName, String gameName) {
        // Логика получения игроков команды
        return List.of(); // Вернуть список игроков
    }

    public List<String> callGetTeamNamesByGame(String gameName) {
        //сеня ты срешь??????????
        return jdbcTemplate.queryForList("SELECT getTeamNames(?)", String.class, gameName);
    }

    public void callAddTeam(String name, String game, Integer ttl_win, String region) {
        // Логика добавления команды
    }

    public void callDeleteTeam(Long id) {
        // Логика удаления команды
    }
}
