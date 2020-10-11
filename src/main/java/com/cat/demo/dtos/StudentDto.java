package com.cat.demo.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
}
