package com.example.mongodbconfigurationwithspringboot.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;
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

    @Transient
    private double percentage;

    public double getPercentage() {
        if(subject!=null && !subject.isEmpty()) {
            double total = 0;
            for (Subject sub : subject) {
                total += Double.parseDouble(sub.getMarkObtained());
                percentage = total / subject.size();
            }
            return total / subject.size();
        }
        return 0.0;
        }
}
