package com.cenfotec.examen2.service.impl;

import com.cenfotec.examen2.service.ReviewService;
import com.cenfotec.examen2.domain.Review;
import com.cenfotec.examen2.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing Review.
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    private final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * Save a review.
     *
     * @param review the entity to save
     * @return the persisted entity
     */
    @Override
    public Review save(Review review) {
        log.debug("Request to save Review : {}", review);
        return reviewRepository.save(review);
    }

    /**
     * Get all the reviews.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<Review> findAll(Pageable pageable) {
        log.debug("Request to get all Reviews");
        return reviewRepository.findAll(pageable);
    }


    /**
     * Get one review by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public Optional<Review> findOne(String id) {
        log.debug("Request to get Review : {}", id);
        return reviewRepository.findById(id);
    }

    /**
     * Delete the review by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Review : {}", id);
        reviewRepository.deleteById(id);
    }
}
