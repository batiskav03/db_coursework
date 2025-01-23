package com.senechka.course_back.services;

import com.senechka.course_back.entities.Player;
import com.senechka.course_back.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public void addPlayer(String name, String team) {
        Player player = new Player();
        player.setName(name);
        player.setTeam(team);
        playerRepository.save(player);
    }

    public List<Player> viewPlayers() {
        return playerRepository.findAll();
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
