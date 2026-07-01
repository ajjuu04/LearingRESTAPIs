package com.ajinkyajambhulkar.learing.RESTAPIs.service.impl;

import com.ajinkyajambhulkar.learing.RESTAPIs.dto.AddStudentRequestDto;
import com.ajinkyajambhulkar.learing.RESTAPIs.dto.StudentDto;
import com.ajinkyajambhulkar.learing.RESTAPIs.dto.StudentEmailUpdate;
import com.ajinkyajambhulkar.learing.RESTAPIs.repositary.StudentRepository;
import com.ajinkyajambhulkar.learing.RESTAPIs.service.StudentService;
import com.ajinkyajambhulkar.learing.RESTAPIs.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto , Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
//        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
//        studentRepository.deleteById(id);
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student not found by " + id);
        }
        studentRepository.deleteById(id);
        
        }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Syudent not avaible in the list"));
        modelMapper.map(addStudentRequestDto,student);

        studentRepository.save(student);

        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto studentupdateEmail(Long id, StudentEmailUpdate studentEmailUpdate) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(("w edidint fina the sdame name studnet")));
        return null;
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not avaible in the list"));

        updates.forEach((field, value) -> {
            switch (field){
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supportted");
            }
        });

        studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);


    }


}

