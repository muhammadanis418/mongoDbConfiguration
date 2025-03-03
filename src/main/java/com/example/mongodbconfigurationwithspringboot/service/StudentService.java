package com.example.mongodbconfigurationwithspringboot.service;

import com.example.mongodbconfigurationwithspringboot.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    Student findById(String id);
    List<Student> findAll();
    Student update(Student student);
    String delete(String id);
}
