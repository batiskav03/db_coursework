package com.senechka.course_back.Requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TourAddRequest {
    private String name;
    private Integer prizepool;
    private String game;
    private String country;
    private String winner_name;
}
