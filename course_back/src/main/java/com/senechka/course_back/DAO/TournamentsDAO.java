package com.senechka.course_back.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TournamentsDAO {
    private final JdbcTemplate jdbcTemplate;

    public TournamentsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void callAddTournament(String name, Integer prizepool, String game,  String country, String winner_name){
        jdbcTemplate.update("CALL addTournament(?, ?, ?, ?, ?)", name, prizepool, game, country, winner_name);
    }

    public void callSetWinner(String name, String winner){
        jdbcTemplate.update("CALL setTourWinner(?, ?)", name, winner);
    }

    public List<String> callViewTournament(String name){
        return jdbcTemplate.queryForList("SELECT (getTourInfo(?))", String.class, name);
    }

    public void callDeleteTournament(Long id) {
        // Логика удаления турнира
    }
}
