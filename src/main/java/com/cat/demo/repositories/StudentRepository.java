package com.cat.demo.repositories;

import com.cat.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student findByFirstName(String firstName);
}
