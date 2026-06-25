package com.ajinkyajambhulkar.learing.RESTAPIs.service.impl;

import com.ajinkyajambhulkar.learing.RESTAPIs.dto.StudentDto;
import com.ajinkyajambhulkar.learing.RESTAPIs.repositary.StudentRepository;
import com.ajinkyajambhulkar.learing.RESTAPIs.service.StudentService;
import com.ajinkyajambhulkar.learing.RESTAPIs.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> new StudentDto(student.getId(),student.getName(), student.getEmail())).
                toList();
        
        return studentDtoList;
    }

    @Override
    public StudentDto getStudnetById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Studnet not Found"));
//        StudentDto studentDto = new StudentDto(student.getId(),student.getName(), student.getEmail());
        return modelMapper.map(student, StudentDto.class);


//        return studentDto;
    }
}
