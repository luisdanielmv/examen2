package com.cenfotec.examen2.service.impl;

import com.cenfotec.examen2.service.ProjectService;
import com.cenfotec.examen2.domain.Project;
import com.cenfotec.examen2.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing Project.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Save a project.
     *
     * @param project the entity to save
     * @return the persisted entity
     */
    @Override
    public Project save(Project project) {
        log.debug("Request to save Project : {}", project);
        return projectRepository.save(project);
    }

    /**
     * Get all the projects.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<Project> findAll(Pageable pageable) {
        log.debug("Request to get all Projects");
        return projectRepository.findAll(pageable);
    }


    /**
     * Get one project by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public Optional<Project> findOne(String id) {
        log.debug("Request to get Project : {}", id);
        return projectRepository.findById(id);
    }

    /**
     * Delete the project by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Project : {}", id);
        projectRepository.deleteById(id);
    }
}
