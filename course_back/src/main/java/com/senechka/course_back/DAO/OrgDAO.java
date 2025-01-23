package com.senechka.course_back.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrgDAO {
    private final JdbcTemplate jdbcTemplate;


    public OrgDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void callAddOrg(String name, String disc) {
        // Логика добавления организации
    }

    public void callRemOrg(String name) {
        // Логика удаления организации
    }

    public List<String> callViewOrgs() {
        // Логика получения списка организаций
        return List.of(); // Вернуть список организаций
    }
}
