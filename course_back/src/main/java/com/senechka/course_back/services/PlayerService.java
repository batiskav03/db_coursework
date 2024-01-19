package com.senechka.course_back.services;

import com.senechka.course_back.DAO.PlayerDAO;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void deletePlayer(String nickname){
        playerDAO.callPlayerDelete(nickname);
    }
}
