package com.senechka.course_back.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDAO {
    private final JdbcTemplate jdbcTemplate;


    public PlayerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void callPlayerDelete(String nickname) {
        jdbcTemplate.update("CALL deletePlayer(?)", nickname);
    }
}
