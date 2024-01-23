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
        return jdbcTemplate.query(
                "SELECT getTeamPlayers(?, ?)",
                new Object[]{teamName, gameName},
                (rs, rowNum) -> rs.getString(1)
        );

    }

    public List<String> callGetTeamNamesByGame(String gameName) {
        //сеня ты срешь??????????
        return jdbcTemplate.queryForList("SELECT getTeamNames(?)", String.class, gameName);
    }

    public void callAddTeam(String name, String game, Integer ttl_win, String region ){
        jdbcTemplate.update("CALL addTeam(? ,? ,?, ?)", name, game, ttl_win, region );
    }
}
