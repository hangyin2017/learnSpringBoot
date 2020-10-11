package com.cat.demo.services;

//import com.cat.demo.dtos.Student;
//import com.cat.demo.repositories.StudentRepository;
import com.cat.demo.dtos.StudentDto;
import com.cat.demo.entities.StudentEntity;
import com.cat.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDto getStudent() {
        return StudentDto.builder()
                .firstName("Cat")
                .lastName("JR")
                .age(20)
                .build();
    }

    public StudentDto createStudent(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setPassword("334455");

        StudentEntity returnedEntity = studentRepository.save(studentEntity);

        return StudentDto.builder()
                .firstName(returnedEntity.getFirstName())
                .lastName(returnedEntity.getLastName())
                .age(returnedEntity.getAge())
                .build();
    }
}
