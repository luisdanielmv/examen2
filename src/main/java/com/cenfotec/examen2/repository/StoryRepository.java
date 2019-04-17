package com.cenfotec.examen2.repository;

import com.cenfotec.examen2.domain.Story;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the Story entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StoryRepository extends MongoRepository<Story, String> {

}
