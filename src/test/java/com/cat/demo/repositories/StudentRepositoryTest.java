package com.cat.demo.repositories;

import com.cat.demo.DemoApplication;
import com.cat.demo.entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void shouldAddStudentIntoDBSuccessfullyGivenProperStudentObjectProvided() {
        Student student = new Student();
        student.setFirstName("tiger");
        student.setPassword("abc");
        Student returnedStudent = studentRepository.save(student);
        Assertions.assertEquals("tiger", returnedStudent.getFirstName());
        Assertions.assertNotNull(returnedStudent.getPassword());
    }
}
