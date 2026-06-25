package com.ajinkyajambhulkar.learing.RESTAPIs.service;
import com.ajinkyajambhulkar.learing.RESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudnetById(Long id);
}
