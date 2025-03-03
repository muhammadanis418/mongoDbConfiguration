package com.example.mongodbconfigurationwithspringboot.controller;

import com.example.mongodbconfigurationwithspringboot.entity.Student;
import com.example.mongodbconfigurationwithspringboot.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable String id) {
        return studentService.findById(id);
    }

    @GetMapping
    public List<Student>findAll() {
        return studentService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
      return studentService.delete(id);
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }
}
