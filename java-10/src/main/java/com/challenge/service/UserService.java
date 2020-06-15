package com.challenge.service.classes;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    private UserRepository repository;

    @Override
    public Optional<User> findById(Long userId) {

        return repository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return repository.findByCandidatesIdAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {

        return repository.findByCandidatesIdCompanyId(companyId);
    }

    @Override
    public User save(User object) {
        return repository.save(object);
    }
}