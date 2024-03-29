package com.cenfotec.examen2.repository;

import com.cenfotec.examen2.domain.Team;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the Team entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TeamRepository extends MongoRepository<Team, String> {

}
