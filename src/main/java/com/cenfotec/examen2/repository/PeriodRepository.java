package com.cenfotec.examen2.repository;

import com.cenfotec.examen2.domain.Period;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the Period entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PeriodRepository extends MongoRepository<Period, String> {

}
