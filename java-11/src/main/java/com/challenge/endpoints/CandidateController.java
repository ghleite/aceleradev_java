package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<CandidateDTO> findById
            (@PathVariable  Long userId, @PathVariable Long accelerationId, @PathVariable Long companyId) {
        Optional<Candidate> candidate = this.candidateService.findById(userId, companyId, accelerationId);
        return ResponseEntity.ok(candidateMapper.map(candidate.get()));
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> findByCompanyIdOrAccelerationId
            (@RequestParam(required = false) Long companyId, @RequestParam(required = false) Long accelerationId) {
        if (companyId != null)
            return ResponseEntity.ok(candidateMapper.map(this.candidateService.findByCompanyId(companyId)));
        if (accelerationId != null)
            return ResponseEntity.ok(candidateMapper.map(this.candidateService.findByAccelerationId(accelerationId)));
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
    }
}