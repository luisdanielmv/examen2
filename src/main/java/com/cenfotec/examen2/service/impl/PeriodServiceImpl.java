package com.cenfotec.examen2.service.impl;

import com.cenfotec.examen2.service.PeriodService;
import com.cenfotec.examen2.domain.Period;
import com.cenfotec.examen2.repository.PeriodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing Period.
 */
@Service
public class PeriodServiceImpl implements PeriodService {

    private final Logger log = LoggerFactory.getLogger(PeriodServiceImpl.class);

    private final PeriodRepository periodRepository;

    public PeriodServiceImpl(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    /**
     * Save a period.
     *
     * @param period the entity to save
     * @return the persisted entity
     */
    @Override
    public Period save(Period period) {
        log.debug("Request to save Period : {}", period);
        return periodRepository.save(period);
    }

    /**
     * Get all the periods.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<Period> findAll(Pageable pageable) {
        log.debug("Request to get all Periods");
        return periodRepository.findAll(pageable);
    }


    /**
     * Get one period by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public Optional<Period> findOne(String id) {
        log.debug("Request to get Period : {}", id);
        return periodRepository.findById(id);
    }

    /**
     * Delete the period by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Period : {}", id);
        periodRepository.deleteById(id);
    }
}
