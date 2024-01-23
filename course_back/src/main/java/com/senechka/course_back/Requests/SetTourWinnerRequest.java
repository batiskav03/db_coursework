package com.senechka.course_back.Requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SetTourWinnerRequest {
    private String name;
    private String winner;
}
