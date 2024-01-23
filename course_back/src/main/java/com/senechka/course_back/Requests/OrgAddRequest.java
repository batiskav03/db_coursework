package com.senechka.course_back.Requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class OrgAddRequest {
    private String name;
    private String disc;
}
