package com.cat.demo.controllers;

import com.cat.demo.dtos.student.StudentGetDto;
import com.cat.demo.dtos.student.StudentPostDto;
import com.cat.demo.dtos.student.StudentPutDto;
import com.cat.demo.entities.Student;
import com.cat.demo.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<List<Student>> find() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("search")
    public ResponseEntity<StudentGetDto> findByName(@RequestParam String studentName) {
        return ResponseEntity.ok(studentService.findStudentByName(studentName));
    }

    @PostMapping
    public ResponseEntity<StudentGetDto> add(@RequestBody StudentPostDto studentPostDto) {
        StudentGetDto studentGetDto = studentService.create(studentPostDto);
        return ResponseEntity.ok(studentGetDto);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentGetDto> update(@PathVariable UUID studentId, @RequestBody StudentPutDto studentPutDto) {
        return ResponseEntity.ok(studentService.modify(studentId, studentPutDto));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity delete(@PathVariable UUID studentId) {
        studentService.delete(studentId);
        return ResponseEntity.ok().build();
    }
}
