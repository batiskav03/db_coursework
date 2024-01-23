package com.senechka.course_back.services;

import com.senechka.course_back.DAO.TournamentsDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentsService {
    private final TournamentsDAO tournamentsDAO;

    public TournamentsService(TournamentsDAO tournamentsDAO) {
        this.tournamentsDAO = tournamentsDAO;
    }

    public void addTour(String name, Integer prizepool, String game, String country, String winner_name){
        tournamentsDAO.callAddTournament(name, prizepool, game, country, winner_name);
    }

    public void setWinner(String name, String winner){
        tournamentsDAO.callSetWinner(name,  winner);
    }

    public List<String> viewTour(String name ) { return tournamentsDAO.callViewTournament(name); }
}
