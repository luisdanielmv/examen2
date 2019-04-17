package com.cenfotec.examen2.web.rest;

import com.cenfotec.examen2.Examen2App;

import com.cenfotec.examen2.domain.Team;
import com.cenfotec.examen2.repository.TeamRepository;
import com.cenfotec.examen2.service.TeamService;
import com.cenfotec.examen2.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import java.util.List;


import static com.cenfotec.examen2.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the TeamResource REST controller.
 *
 * @see TeamResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Examen2App.class)
public class TeamResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restTeamMockMvc;

    private Team team;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TeamResource teamResource = new TeamResource(teamService);
        this.restTeamMockMvc = MockMvcBuilders.standaloneSetup(teamResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Team createEntity() {
        Team team = new Team()
            .name(DEFAULT_NAME)
            .status(DEFAULT_STATUS);
        return team;
    }

    @Before
    public void initTest() {
        teamRepository.deleteAll();
        team = createEntity();
    }

    @Test
    public void createTeam() throws Exception {
        int databaseSizeBeforeCreate = teamRepository.findAll().size();

        // Create the Team
        restTeamMockMvc.perform(post("/api/teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(team)))
            .andExpect(status().isCreated());

        // Validate the Team in the database
        List<Team> teamList = teamRepository.findAll();
        assertThat(teamList).hasSize(databaseSizeBeforeCreate + 1);
        Team testTeam = teamList.get(teamList.size() - 1);
        assertThat(testTeam.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testTeam.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    public void createTeamWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = teamRepository.findAll().size();

        // Create the Team with an existing ID
        team.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restTeamMockMvc.perform(post("/api/teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(team)))
            .andExpect(status().isBadRequest());

        // Validate the Team in the database
        List<Team> teamList = teamRepository.findAll();
        assertThat(teamList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = teamRepository.findAll().size();
        // set the field null
        team.setName(null);

        // Create the Team, which fails.

        restTeamMockMvc.perform(post("/api/teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(team)))
            .andExpect(status().isBadRequest());

        List<Team> teamList = teamRepository.findAll();
        assertThat(teamList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = teamRepository.findAll().size();
        // set the field null
        team.setStatus(null);

        // Create the Team, which fails.

        restTeamMockMvc.perform(post("/api/teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(team)))
            .andExpect(status().isBadRequest());

        List<Team> teamList = teamRepository.findAll();
        assertThat(teamList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void getAllTeams() throws Exception {
        // Initialize the database
        teamRepository.save(team);

        // Get all the teamList
        restTeamMockMvc.perform(get("/api/teams?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(team.getId())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())));
    }
    
    @Test
    public void getTeam() throws Exception {
        // Initialize the database
        teamRepository.save(team);

        // Get the team
        restTeamMockMvc.perform(get("/api/teams/{id}", team.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(team.getId()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()));
    }

    @Test
    public void getNonExistingTeam() throws Exception {
        // Get the team
        restTeamMockMvc.perform(get("/api/teams/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateTeam() throws Exception {
        // Initialize the database
        teamService.save(team);

        int databaseSizeBeforeUpdate = teamRepository.findAll().size();

        // Update the team
        Team updatedTeam = teamRepository.findById(team.getId()).get();
        updatedTeam
            .name(UPDATED_NAME)
            .status(UPDATED_STATUS);

        restTeamMockMvc.perform(put("/api/teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedTeam)))
            .andExpect(status().isOk());

        // Validate the Team in the database
        List<Team> teamList = teamRepository.findAll();
        assertThat(teamList).hasSize(databaseSizeBeforeUpdate);
        Team testTeam = teamList.get(teamList.size() - 1);
        assertThat(testTeam.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testTeam.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    public void updateNonExistingTeam() throws Exception {
        int databaseSizeBeforeUpdate = teamRepository.findAll().size();

        // Create the Team

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTeamMockMvc.perform(put("/api/teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(team)))
            .andExpect(status().isBadRequest());

        // Validate the Team in the database
        List<Team> teamList = teamRepository.findAll();
        assertThat(teamList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteTeam() throws Exception {
        // Initialize the database
        teamService.save(team);

        int databaseSizeBeforeDelete = teamRepository.findAll().size();

        // Get the team
        restTeamMockMvc.perform(delete("/api/teams/{id}", team.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Team> teamList = teamRepository.findAll();
        assertThat(teamList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Team.class);
        Team team1 = new Team();
        team1.setId("id1");
        Team team2 = new Team();
        team2.setId(team1.getId());
        assertThat(team1).isEqualTo(team2);
        team2.setId("id2");
        assertThat(team1).isNotEqualTo(team2);
        team1.setId(null);
        assertThat(team1).isNotEqualTo(team2);
    }
}
