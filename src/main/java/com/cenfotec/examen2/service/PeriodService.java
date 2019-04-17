package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Period;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Period.
 */
public interface PeriodService {

    /**
     * Save a period.
     *
     * @param period the entity to save
     * @return the persisted entity
     */
    Period save(Period period);

    /**
     * Get all the periods.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<Period> findAll(Pageable pageable);


    /**
     * Get the "id" period.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Period> findOne(String id);

    /**
     * Delete the "id" period.
     *
     * @param id the id of the entity
     */
    void delete(String id);
}
