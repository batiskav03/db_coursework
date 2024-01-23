package com.senechka.course_back.Controllers;

import com.senechka.course_back.Requests.OrgAddRequest;
import com.senechka.course_back.Requests.RemOrgRequest;
import com.senechka.course_back.Requests.SetTourWinnerRequest;
import com.senechka.course_back.Requests.TourAddRequest;
import com.senechka.course_back.services.OrgService;
import com.senechka.course_back.services.TournamentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class TournamentsController {

    private final TournamentsService tournamentsService;

    @Autowired
    public TournamentsController(TournamentsService tournamentsService) {
        this.tournamentsService = tournamentsService;
    }

    @PostMapping("/addTournament")
    public void addTour(@RequestBody TourAddRequest request) {
        System.out.println("name:"+ request.getName());
        tournamentsService.addTour(request.getName(), request.getPrizepool(), request.getGame(), request.getCountry(), request.getWinner_name());
    }
    @PostMapping("/setWinner")
    public void setWinner(@RequestBody SetTourWinnerRequest request) {
        tournamentsService.setWinner(request.getName(), request.getWinner());
    }
}