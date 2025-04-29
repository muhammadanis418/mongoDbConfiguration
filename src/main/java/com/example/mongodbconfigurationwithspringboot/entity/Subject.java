package com.example.mongodbconfigurationwithspringboot.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("subject")
public class Subject {

    private String id;
    @Field(name = "subject_name")
    private String subjectName;
    @Field(name = "mark_obtained")
    private String markObtained;

}
