package com.senechka.course_back.Requests;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamAddRequest {
    private String name;
    private String game;
    private Integer ttl_win;
    private String region;
}
