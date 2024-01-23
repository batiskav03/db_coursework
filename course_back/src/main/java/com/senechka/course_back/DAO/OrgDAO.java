package com.senechka.course_back.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrgDAO {
    private final JdbcTemplate jdbcTemplate;


    public OrgDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void callAddOrg(String name, String disc){
        System.out.println("name"+ name);
        jdbcTemplate.update("CALL addOrg(?, ?)", name, disc);
    }
}
