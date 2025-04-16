package com.example.mongodbconfigurationwithspringboot.repository;

import com.example.mongodbconfigurationwithspringboot.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

    Student findByNameAndEmail(String name, String email);

    Student findByNameOrEmail(String name, String email);

    List<Student>findByDepartmentDepartmentName(String departmentName);

    List<Student>findBySubjectSubjectName(String subjectName);

}
