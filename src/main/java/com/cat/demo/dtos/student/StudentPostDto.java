package com.cat.demo.dtos.student;

import lombok.Data;

@Data
public class StudentPostDto {
    private String firstName;
    private String lastName;
    private int age;
    private String password;
}
