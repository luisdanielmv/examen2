package com.cenfotec.examen2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Team.
 */
@Document(collection = "team")
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("status")
    private String status;

    @DBRef
    @Field("project")
    @JsonIgnoreProperties("teams")
    private Project project;

    @DBRef
    @Field("sprints")
    private Set<Sprint> sprints = new HashSet<>();
    @DBRef
    @Field("students")
    private Set<Student> students = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Team name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public Team status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public Team project(Project project) {
        this.project = project;
        return this;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<Sprint> getSprints() {
        return sprints;
    }

    public Team sprints(Set<Sprint> sprints) {
        this.sprints = sprints;
        return this;
    }

    public Team addSprints(Sprint sprint) {
        this.sprints.add(sprint);
        sprint.setTeam(this);
        return this;
    }

    public Team removeSprints(Sprint sprint) {
        this.sprints.remove(sprint);
        sprint.setTeam(null);
        return this;
    }

    public void setSprints(Set<Sprint> sprints) {
        this.sprints = sprints;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Team students(Set<Student> students) {
        this.students = students;
        return this;
    }

    public Team addStudents(Student student) {
        this.students.add(student);
        student.setTeam(this);
        return this;
    }

    public Team removeStudents(Student student) {
        this.students.remove(student);
        student.setTeam(null);
        return this;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Team team = (Team) o;
        if (team.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), team.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Team{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
