package com.senechka.course_back.services;

import org.springframework.stereotype.Service;

@Service
public class FormService {

    public void processForm(FormRequest formRequest) {
        // Логика обработки данных формы
        System.out.println("Field 1: " + formRequest.getField1());
        System.out.println("Field 2: " + formRequest.getField2());
    }
} 