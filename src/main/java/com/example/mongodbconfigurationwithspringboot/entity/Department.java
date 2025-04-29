package com.example.mongodbconfigurationwithspringboot.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("department")
public class Department {

    private String id;
    @Field(name = "dept_name")
    private String departmentName;
    private String location;
}
