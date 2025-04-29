package com.example.mongodbconfigurationwithspringboot.repository;

import com.example.mongodbconfigurationwithspringboot.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {
}
