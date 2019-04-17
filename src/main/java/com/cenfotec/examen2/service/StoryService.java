package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Story;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Story.
 */
public interface StoryService {

    /**
     * Save a story.
     *
     * @param story the entity to save
     * @return the persisted entity
     */
    Story save(Story story);

    /**
     * Get all the stories.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<Story> findAll(Pageable pageable);


    /**
     * Get the "id" story.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Story> findOne(String id);

    /**
     * Delete the "id" story.
     *
     * @param id the id of the entity
     */
    void delete(String id);
}
