package com.example.mongodbconfigurationwithspringboot.repository;

import com.example.mongodbconfigurationwithspringboot.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

}
