package com.cat.demo.services;

import com.cat.demo.dtos.student.StudentGetDto;
import com.cat.demo.dtos.student.StudentPostDto;
import com.cat.demo.dtos.student.StudentPutDto;
import com.cat.demo.entities.Student;
import com.cat.demo.mappers.StudentMapper;
import com.cat.demo.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentGetDto findByFirstName(String firstName) {
        return studentMapper.fromEntity(studentRepository.findByLastName(firstName));
    }

    public StudentGetDto add(StudentPostDto studentPostDto) {
        Student studentEntity = studentMapper.toEntity(studentPostDto);
        return studentMapper.fromEntity(studentRepository.save(studentEntity));
    }

    public StudentGetDto modify(UUID studentId, StudentPutDto studentPutDto) {
        Student student = new Student();
        studentMapper.copy(studentPutDto, student);
        student.setId(studentId);
        return studentMapper.fromEntity(studentRepository.save(student));
    }

    public Student delete(UUID id) {
        Student student = studentRepository.findById(id).get();
        //Student student = studentRepository.getOne(id);
        studentRepository.deleteById(id);
        return student;
    }
}
