package com.senechka.course_back.services;

import com.senechka.course_back.DAO.PlayerDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void deletePlayer(String nickname){
        playerDAO.callPlayerDelete(nickname);
    }

    public void addPlayer(String nickname, String firstName, String surname, String birthDay, Integer ttlWin, String teamName, String playerCountry) {
        playerDAO.callAddPlayer(nickname, firstName, surname, birthDay, ttlWin, teamName, playerCountry);
    }

    public List<String> viewPlayers(){
        return playerDAO.callViewAllPlayers();
    }


}
