package com.challenge.service.classes;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccelerationService implements AccelerationServiceInterface {

    private AccelerationRepository repository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return repository.findByCandidatesIdCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return repository.save(object);
    }
}