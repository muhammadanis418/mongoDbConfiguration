package com.example.mongodbconfigurationwithspringboot.service;

import com.example.mongodbconfigurationwithspringboot.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    Student findById(String id);
    List<Student> findAll(int pageNo, int pageSize);
    Student update(Student student);
    String delete(String id);
    List<Student>findByName(String name);
    Student findByNameAndEmail(String name, String email);
    Student findByNameOrEmail(String name, String email);
    List<Student> findBYDepartmentByDepartmentName(String departmentName);
    List<Student> findBySubjectSubjectName(String subjectName);
    List<Student>findByEmailLike(String email);
    List<Student> findByNameStartsWith(String name);

}
