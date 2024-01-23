package com.senechka.course_back.Requests;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddGameRequest {
    private String name;
    private String desc;
}
