package com.senechka.course_back.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDAO {
    private final JdbcTemplate jdbcTemplate;


    public PlayerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void callPlayerDelete(String nickname) {
        jdbcTemplate.update("CALL deletePlayer(?)", nickname);
    }

    public void callAddPlayer(String nickname, String firstName, String surname, String birthDay, Integer ttlWin, String teamName, String playerCountry ) {
        System.out.println(nickname+firstName+surname+birthDay+ttlWin+ teamName+playerCountry);
        jdbcTemplate.update("CALL addPlayer(?, ?, ?, ?, ?, ?, ?)", nickname, firstName, surname, birthDay, ttlWin, teamName, playerCountry );
    }

    public List<String> callViewAllPlayers(){
        return jdbcTemplate.queryForList("select * from players", String.class);
    }

    public void callAddPlayer(String name, String team) {
        // Логика добавления игрока
    }

    public List<String> callViewPlayers() {
        // Логика получения списка игроков
        return List.of(); // Вернуть список игроков
    }

    public void callDeletePlayer(Long id) {
        // Логика удаления игрока
    }
}
