package com.cat.demo.controllers;

import com.cat.demo.dtos.student.StudentGetDto;
import com.cat.demo.dtos.student.StudentPostDto;
import com.cat.demo.dtos.student.StudentPutDto;
import com.cat.demo.entities.Student;
import com.cat.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/students")
public class DemoController {

    @Autowired
    private StudentService studentService;

    //@GetMapping
    //public ResponseEntity<Object> hello() {
    //    return ResponseEntity.ok("hello");
    //}

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("search")
    public ResponseEntity<StudentGetDto> findByFirstName(@RequestParam String studentName) {
        return ResponseEntity.ok(studentService.findByFirstName(studentName));
    }

    @PostMapping
    public ResponseEntity<StudentGetDto> add(@RequestBody StudentPostDto studentPostDto) {
        StudentGetDto studentGetDto = studentService.add(studentPostDto);
        return ResponseEntity.ok(studentGetDto);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentGetDto> update(@PathVariable UUID studentId, @RequestBody StudentPutDto studentPutDto) {
        return ResponseEntity.ok(studentService.modify(studentId, studentPutDto));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Student> delete(@PathVariable UUID studentId) {
        return ResponseEntity.ok(studentService.delete(studentId));
    }
}
