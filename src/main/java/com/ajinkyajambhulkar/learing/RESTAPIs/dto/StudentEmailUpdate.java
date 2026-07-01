package com.ajinkyajambhulkar.learing.RESTAPIs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEmailUpdate {

    private Long id;
    private String email;
}
