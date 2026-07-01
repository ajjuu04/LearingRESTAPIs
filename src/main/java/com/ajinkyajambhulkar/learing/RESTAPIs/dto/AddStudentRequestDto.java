package com.ajinkyajambhulkar.learing.RESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddStudentRequestDto {

    @NotBlank(message = "Email in Requirde")
    @Size(max = 30, min = 3, message = "Name should be in 3 to 30 charactors ")
    private String name;

    @Email
    @NotBlank(message = "Email in Requirde")
    private String email;
}
