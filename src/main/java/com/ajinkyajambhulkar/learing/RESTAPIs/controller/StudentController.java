package com.ajinkyajambhulkar.learing.RESTAPIs.controller;


import com.ajinkyajambhulkar.learing.RESTAPIs.dto.AddStudentRequestDto;
import com.ajinkyajambhulkar.learing.RESTAPIs.dto.StudentDto;
import com.ajinkyajambhulkar.learing.RESTAPIs.dto.StudentEmailUpdate;
import com.ajinkyajambhulkar.learing.RESTAPIs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping //("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
//        return ResponseEntity.status(HttpStatusCode.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudnetById(id));
    }

//    @GetMapping("/Collage")
//    public StudentDto getCollage(){
//        return new StudentDto(69L,"Ajinkya","aj@gmail.com");
//    }


    @PostMapping("")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable Long id,@RequestBody AddStudentRequestDto addStudentRequestDto){
        return studentService.updateStudent(id,addStudentRequestDto);
    }

    @PatchMapping("/{id}")
    public StudentDto updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return studentService.updatePartialStudent(id,updates);
    }







}
