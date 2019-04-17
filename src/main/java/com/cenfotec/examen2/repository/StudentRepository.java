package com.cenfotec.examen2.repository;

import com.cenfotec.examen2.domain.Student;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the Student entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
