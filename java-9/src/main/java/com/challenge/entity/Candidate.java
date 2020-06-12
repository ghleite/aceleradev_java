package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

    @EmbeddedId
    private CandidateIdentity candidateIdentity;

    @NotNull
    @NotBlank
    private Integer status;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Embeddable
    @EntityListeners(AuditingEntityListener.class)
    private class CandidateIdentity implements Serializable {

        @NotNull
        @ManyToOne
        private User userId;

        @NotNull
        @ManyToOne
        private Acceleration accelerationId;

        @NotNull
        @ManyToOne
        private Company companyId;

    }

    public Candidate() {}
}
