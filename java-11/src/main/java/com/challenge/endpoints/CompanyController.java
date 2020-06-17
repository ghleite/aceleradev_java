package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.companyService.findById(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Company>> findByAccelerationIdOrUserId
            (@RequestParam(required = false) Long accelerationId, @RequestParam(required = false) Long userId) {
        if (accelerationId != null)
            return ResponseEntity.ok(this.companyService.findByAccelerationId(accelerationId));
        if (userId != null)
            return ResponseEntity.ok(this.companyService.findByUserId(userId));
        return null;
    }
}