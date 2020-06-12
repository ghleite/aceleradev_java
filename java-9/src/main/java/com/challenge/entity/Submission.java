package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Submission {

    @EmbeddedId
    private SubmissionIdentity submissionIdentity;

    @NotNull
    @Size(min = 0)
    private Double score;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Embeddable
    @EntityListeners(AuditingEntityListener.class)
    private class SubmissionIdentity implements Serializable {

        @NotNull
        @ManyToOne
        private User userId;

        @NotNull
        @ManyToOne
        private Challenge challengeId;
    }

    public Submission() {}
}
