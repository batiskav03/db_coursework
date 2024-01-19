package com.senechka.course_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@SpringBootApplication
public class CourseBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseBackApplication.class, args);
    }

}
