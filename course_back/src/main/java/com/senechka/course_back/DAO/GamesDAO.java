package com.senechka.course_back.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GamesDAO {


    private final JdbcTemplate jdbcTemplate;


    public GamesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> callViewAllGames() {
        return jdbcTemplate.query("SELECT NAME, games.description FROM GAMES", (rs, rowNum) ->
                rs.getString("name") + " - " + rs.getString("description"));
    }


    public void callRemOrg(String name){
        jdbcTemplate.update("CALL remOrg(?)", name);
    }

    public List<String> callViewOrgs(){
        return jdbcTemplate.queryForList("SELECT NAME FROM ORGANIZATIONS", String.class);
    }

    public void addGame(String name, String desc) {
        jdbcTemplate.update("CALL addGame(?, ? )", name, desc);
    }
}
