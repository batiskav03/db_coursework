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

    public List<String> callGetTeamPlayers(String param1, String param2) {
        // Используем query для выполнения запроса с возвращаемыми результатами
        return jdbcTemplate.query(
                "SELECT getTeamPlayers(?, ?)",
                new Object[]{param1, param2},
                (rs, rowNum) -> rs.getString(1)
        );

    }
}
