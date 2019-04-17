package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Sprint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Sprint.
 */
public interface SprintService {

    /**
     * Save a sprint.
     *
     * @param sprint the entity to save
     * @return the persisted entity
     */
    Sprint save(Sprint sprint);

    /**
     * Get all the sprints.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<Sprint> findAll(Pageable pageable);


    /**
     * Get the "id" sprint.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Sprint> findOne(String id);

    /**
     * Delete the "id" sprint.
     *
     * @param id the id of the entity
     */
    void delete(String id);
}
