package com.example.mongodbconfigurationwithspringboot.service;

import com.example.mongodbconfigurationwithspringboot.entity.Student;
import com.example.mongodbconfigurationwithspringboot.repository.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    public List<Student> findAll(int pageNo, int pageSize) {
       Sort sort = Sort.by(Sort.Direction.ASC, "name","email");
        Pageable pageable = PageRequest.of(pageNo-1, pageSize,sort);
        return studentRepository.findAll(pageable).getContent();
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
    @Override
    public List<Student> findByName(@PathVariable String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student findByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    @Override
    public Student findByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    @Override
    public List<Student> findBYDepartmentByDepartmentName(String departmentName) {
        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }

    @Override
    public List<Student> findBySubjectSubjectName(String subjectName) {
        return studentRepository.findBySubjectSubjectName(subjectName);
    }
}
