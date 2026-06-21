package com.ajinkyajambhulkar.learing.RESTAPIs.controller;


import com.ajinkyajambhulkar.learing.RESTAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto StudentDto(){
        return new StudentDto(69L,"Ajinkya","aj@gmail.com");
    }



}
