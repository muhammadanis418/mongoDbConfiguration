package com.example.mongodbconfigurationwithspringboot.repository;

import com.example.mongodbconfigurationwithspringboot.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

  //  Student findByNameAndEmail(String name, String email);

    Student findByNameOrEmail(String name, String email);
    /*
    This type of queries will only work if we have embedded subdocument
    whenever we have subdocument with debRef annotation below queries will throw an error
     */
//    List<Student>findByDepartmentDepartmentName(String departmentName);
//    List<Student>findBySubjectSubjectName(String subjectName);

    List<Student>findByDepartment_Id(String depId);
    List<Student>findBySubject_Id(String subId);

    List<Student>findByEmailLike(String email);

    List<Student> findByNameStartsWith(String name);

    @Query("{ \"name\" :  \"?0\",\"email\" : \"?1\"}")
    Student getByNameAndEmail(String name, String email);

}
