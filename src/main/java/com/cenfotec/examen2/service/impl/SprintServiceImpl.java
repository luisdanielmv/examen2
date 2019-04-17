package com.cenfotec.examen2.service.impl;

import com.cenfotec.examen2.service.SprintService;
import com.cenfotec.examen2.domain.Sprint;
import com.cenfotec.examen2.repository.SprintRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing Sprint.
 */
@Service
public class SprintServiceImpl implements SprintService {

    private final Logger log = LoggerFactory.getLogger(SprintServiceImpl.class);

    private final SprintRepository sprintRepository;

    public SprintServiceImpl(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    /**
     * Save a sprint.
     *
     * @param sprint the entity to save
     * @return the persisted entity
     */
    @Override
    public Sprint save(Sprint sprint) {
        log.debug("Request to save Sprint : {}", sprint);
        return sprintRepository.save(sprint);
    }

    /**
     * Get all the sprints.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<Sprint> findAll(Pageable pageable) {
        log.debug("Request to get all Sprints");
        return sprintRepository.findAll(pageable);
    }


    /**
     * Get one sprint by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public Optional<Sprint> findOne(String id) {
        log.debug("Request to get Sprint : {}", id);
        return sprintRepository.findById(id);
    }

    /**
     * Delete the sprint by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Sprint : {}", id);
        sprintRepository.deleteById(id);
    }
}
