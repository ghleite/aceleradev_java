package com.challenge.service.classes;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class SubmissionService implements SubmissionServiceInterface {

    private SubmissionRepository repository;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return repository.findHigherScoreByChallengeId(challengeId).orElse(BigDecimal.ZERO);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return repository.save(object);
    }
}