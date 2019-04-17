package com.cenfotec.examen2.service.impl;

import com.cenfotec.examen2.service.StoryService;
import com.cenfotec.examen2.domain.Story;
import com.cenfotec.examen2.repository.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing Story.
 */
@Service
public class StoryServiceImpl implements StoryService {

    private final Logger log = LoggerFactory.getLogger(StoryServiceImpl.class);

    private final StoryRepository storyRepository;

    public StoryServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    /**
     * Save a story.
     *
     * @param story the entity to save
     * @return the persisted entity
     */
    @Override
    public Story save(Story story) {
        log.debug("Request to save Story : {}", story);
        return storyRepository.save(story);
    }

    /**
     * Get all the stories.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<Story> findAll(Pageable pageable) {
        log.debug("Request to get all Stories");
        return storyRepository.findAll(pageable);
    }


    /**
     * Get one story by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public Optional<Story> findOne(String id) {
        log.debug("Request to get Story : {}", id);
        return storyRepository.findById(id);
    }

    /**
     * Delete the story by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Story : {}", id);
        storyRepository.deleteById(id);
    }
}
