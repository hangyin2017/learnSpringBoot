package com.cat.demo.controllers;

import com.cat.demo.dtos.StudentDto;
import com.cat.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class DemoController {

    @Autowired
    private StudentService studentService;

    //@GetMapping
    //public ResponseEntity<Object> hello() {
    //    return ResponseEntity.ok("hello");
    //}

    @GetMapping
    public ResponseEntity<StudentDto> getStudent() {
        return ResponseEntity.ok(studentService.getStudent());
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto response = studentService.createStudent(studentDto);
        return ResponseEntity.ok(response);
    }
}
