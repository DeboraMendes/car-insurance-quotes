package br.com.audsat.carinsurancequotes.services.insurance.impl;

import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;
import br.com.audsat.carinsurancequotes.exceptions.ResourceNotFoundException;
import br.com.audsat.carinsurancequotes.repositories.InsuranceRepository;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceDeleterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InsuranceDeleterServiceImpl implements InsuranceDeleterService {

    private final InsuranceRepository insuranceRepository;

    public void deleteInsuranceById(final Long id) {
        log.info("Deleting insurance with id {}", id);

        final InsuranceEntity insuranceEntity = insuranceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insurance not found."));

        insuranceRepository.delete(insuranceEntity);

        log.info("Insurance deleted");
    }
}
