package com.senechka.course_back.services;

import com.senechka.course_back.DAO.GamesDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GamesService {

    private final GamesDAO gamesDAO;

    public GamesService(GamesDAO gamesDAO) {
        this.gamesDAO = gamesDAO;
    }

    public List<String> viewGames(){
        return gamesDAO.callViewAllGames();
    }

    public void addGame(String name, String desc) {
        gamesDAO.addGame(name, desc);
    }



}
