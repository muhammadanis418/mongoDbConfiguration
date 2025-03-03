package com.example.mongodbconfigurationwithspringboot.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Department {
    @Field(name = "dept_name")
    private String departmentName;

    private String location;
}
