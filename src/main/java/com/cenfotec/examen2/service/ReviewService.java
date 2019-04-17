package com.cenfotec.examen2.service;

import com.cenfotec.examen2.domain.Review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Review.
 */
public interface ReviewService {

    /**
     * Save a review.
     *
     * @param review the entity to save
     * @return the persisted entity
     */
    Review save(Review review);

    /**
     * Get all the reviews.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<Review> findAll(Pageable pageable);


    /**
     * Get the "id" review.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Review> findOne(String id);

    /**
     * Delete the "id" review.
     *
     * @param id the id of the entity
     */
    void delete(String id);
}
