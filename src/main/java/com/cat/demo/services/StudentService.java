package com.cat.demo.services;

//import com.cat.demo.dtos.Student;
//import com.cat.demo.repositories.StudentRepository;
import com.cat.demo.dtos.student.StudentGetDto;
import com.cat.demo.dtos.student.StudentPostDto;
import com.cat.demo.dtos.student.StudentPutDto;
import com.cat.demo.entities.Student;
import com.cat.demo.mappers.StudentMapper;
import com.cat.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentGetDto findStudentByName(String name) {
        return studentMapper.fromEntity(studentRepository.findByFirstName(name));
    }

    public StudentGetDto create(StudentPostDto studentPostDto) {
        Student studentEntity = studentMapper.toEntity(studentPostDto);
        return studentMapper.fromEntity(studentRepository.save(studentEntity));
    }

    public StudentGetDto modify(UUID studentId, StudentPutDto studentPutDto) {
        Student student = new Student();
        studentMapper.copy(studentPutDto, student);
        student.setId(studentId);
        return studentMapper.fromEntity(studentRepository.save(student));
    }

    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }
}
