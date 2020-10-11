package com.cat.demo.repositories;

import com.cat.demo.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

}
