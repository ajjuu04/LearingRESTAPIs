package com.ajinkyajambhulkar.learing.RESTAPIs.service;
import com.ajinkyajambhulkar.learing.RESTAPIs.dto.AddStudentRequestDto;
import com.ajinkyajambhulkar.learing.RESTAPIs.dto.StudentDto;
import com.ajinkyajambhulkar.learing.RESTAPIs.dto.StudentEmailUpdate;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudnetById(Long id);
    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);
    void deleteStudent(Long id);
    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto studentupdateEmail(Long id, StudentEmailUpdate studentEmailUpdate);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
