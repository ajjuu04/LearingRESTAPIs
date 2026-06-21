package com.ajinkyajambhulkar.learing.RESTAPIs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SrudentDto {
    private Long id;
    private String name;
    private String email;
}
