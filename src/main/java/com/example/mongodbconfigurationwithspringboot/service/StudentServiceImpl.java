package com.example.mongodbconfigurationwithspringboot.service;

import com.example.mongodbconfigurationwithspringboot.entity.Student;
import com.example.mongodbconfigurationwithspringboot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String delete(String id) {
        studentRepository.deleteById(id);
        return "Student with id: " + id + " has been deleted";
    }
}
