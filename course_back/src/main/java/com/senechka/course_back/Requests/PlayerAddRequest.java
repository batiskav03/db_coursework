package com.senechka.course_back.Requests;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerAddRequest {
    private String nickname;
    private String firstName;
    private String surname;
    private String birthDay;
    private int ttlWin;
    private String teamName;
    private String playerCountry;


}
