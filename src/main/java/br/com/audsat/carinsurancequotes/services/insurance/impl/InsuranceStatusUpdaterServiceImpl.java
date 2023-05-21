package br.com.audsat.carinsurancequotes.services.insurance.impl;

import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;
import br.com.audsat.carinsurancequotes.exceptions.BusinessException;
import br.com.audsat.carinsurancequotes.exceptions.ResourceNotFoundException;
import br.com.audsat.carinsurancequotes.repositories.InsuranceRepository;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceStatusUpdaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InsuranceStatusUpdaterServiceImpl implements InsuranceStatusUpdaterService {

    private final InsuranceRepository insuranceRepository;

    @Override
    public void updateInsuranceStatusById(final Long id, final Boolean active) {
        log.info("Find insurance by id {} to update status to {}", id, active);

        final InsuranceEntity insuranceEntity = insuranceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insurance not found."));

        final Boolean currentStatus = insuranceEntity.getIsActive();

        if (active.equals(currentStatus)) {
            throw new BusinessException("The insurance is already in this status.");
        }

        log.info("Updating insurance status with id {} from active = {} to active = {}", id, currentStatus, active);

        insuranceEntity.setIsActive(active);

        insuranceRepository.save(insuranceEntity);

        log.info("Updated insurance");
    }
}
