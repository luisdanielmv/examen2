package com.cenfotec.examen2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Review.
 */
@Document(collection = "review")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("timestamp")
    private LocalDate timestamp;

    @Field("comment")
    private String comment;

    @Field("status")
    private String status;

    @DBRef
    @Field("story")
    @JsonIgnoreProperties("reviews")
    private Story story;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public Review timestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getComment() {
        return comment;
    }

    public Review comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public Review status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Story getStory() {
        return story;
    }

    public Review story(Story story) {
        this.story = story;
        return this;
    }

    public void setStory(Story story) {
        this.story = story;
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
        Review review = (Review) o;
        if (review.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), review.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Review{" +
            "id=" + getId() +
            ", timestamp='" + getTimestamp() + "'" +
            ", comment='" + getComment() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
