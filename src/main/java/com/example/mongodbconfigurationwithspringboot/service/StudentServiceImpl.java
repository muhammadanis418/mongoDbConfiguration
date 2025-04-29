package com.example.mongodbconfigurationwithspringboot.service;

import com.example.mongodbconfigurationwithspringboot.entity.Student;
import com.example.mongodbconfigurationwithspringboot.repository.DepartmentRepository;
import com.example.mongodbconfigurationwithspringboot.repository.StudentRepository;
import com.example.mongodbconfigurationwithspringboot.repository.SubjectRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final SubjectRepository subjectRepository;

    public StudentServiceImpl(StudentRepository studentRepository,DepartmentRepository departmentRepository,SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Student save(Student student) {
        if(student.getDepartment()!=null){
            departmentRepository.save(student.getDepartment());
        }
        if(student.getSubject()!=null && !student.getSubject().isEmpty()){
            subjectRepository.saveAll(student.getSubject());
        }
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
      //  return studentRepository.findByNameAndEmail(name, email);
        return studentRepository.getByNameAndEmail(name, email);
    }

    @Override
    public Student findByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

//    @Override
//    public List<Student> findBYDepartmentByDepartmentName(String departmentName) {
//        return studentRepository.findByDepartmentDepartmentName(departmentName);
//    }
//
//    @Override
//    public List<Student> findBySubjectSubjectName(String subjectName) {
//        return studentRepository.findBySubjectSubjectName(subjectName);
//    }

    @Override
    public List<Student> findByEmailLike(String email) {
        return studentRepository.findByEmailLike(email);
    }

    @Override
    public List<Student> findByNameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    @Override
    public List<Student> findByDepartment_Id(String depId) {
        return studentRepository.findByDepartment_Id(depId);
    }

    @Override
    public List<Student> findBySubject_Id(String subId) {
        return studentRepository.findBySubject_Id(subId);
    }


}
