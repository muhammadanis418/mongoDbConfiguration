package com.example.mongodbconfigurationwithspringboot.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document("student")
public class Student {

    private String id;
    private String name;
    private String age;
    @Field(name = "mail")
    private String email;
    private Department department;
    private List<Subject> subject;
}
