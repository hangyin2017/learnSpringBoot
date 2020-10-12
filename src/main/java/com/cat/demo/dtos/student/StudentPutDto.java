package com.cat.demo.dtos.student;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StudentPutDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
}
