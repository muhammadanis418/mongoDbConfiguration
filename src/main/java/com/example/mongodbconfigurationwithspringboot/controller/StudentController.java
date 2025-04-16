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

    @GetMapping("by-id/{id}")
    public Student findById(@PathVariable String id) {
        return studentService.findById(id);
    }

    @GetMapping
    public List<Student>findAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return studentService.findAll(pageNo, pageSize);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
      return studentService.delete(id);
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }
    @GetMapping("by-name/{name}")
    public List<Student>getStudentByName(@PathVariable String name) {
        return studentService.findByName(name);
    }
   // @GetMapping("search")
    @GetMapping("by-name-and-email")  // More specific for exact matches.
    public Student findByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.findByNameAndEmail(name, email);
    }
    @GetMapping("search")  // Broader, supports optional parameters.
    public Student findByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.findByNameOrEmail(name, email);
    }

    @GetMapping("by-department")
    public List<Student>getStudentsByDepartment(@RequestParam String deptName) {
        return studentService.findBYDepartmentByDepartmentName(deptName);
    }

    @GetMapping("by-subject")
    public List<Student> findBySubjectSubjectName(@RequestParam String subjectName){
        return studentService.findBySubjectSubjectName(subjectName);

    }

}
