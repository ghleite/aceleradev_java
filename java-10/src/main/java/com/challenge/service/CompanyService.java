package com.challenge.service.classes;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService implements CompanyServiceInterface {

    private CompanyRepository repository;

    @Override
    public Optional<Company> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return repository.findDistinctByCandidatesIdAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return repository.findByCandidatesIdUserId(userId);
    }

    @Override
    public Company save(Company object) {
        return repository.save(object);
    }
}