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

    public void callAddOrg(String name, String disc){
        jdbcTemplate.update("CALL addOrg(?, ?)", name, disc);
    }

    public void callRemOrg(String name){
        jdbcTemplate.update("CALL remOrg(?)", name);
    }

    public List<String> callViewOrgs(){
        return jdbcTemplate.queryForList("SELECT NAME FROM ORGANIZATIONS", String.class);
    }
}
