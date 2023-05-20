package br.com.audsat.carinsurancequotes.services.driver.impl;

import br.com.audsat.carinsurancequotes.domains.entities.DriverEntity;
import br.com.audsat.carinsurancequotes.exceptions.ResourceNotFoundException;
import br.com.audsat.carinsurancequotes.repositories.DriverRepository;
import br.com.audsat.carinsurancequotes.services.driver.DriverQueriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DriverQueriesServiceImpl implements DriverQueriesService {

    private final DriverRepository driverRepository;

    public DriverEntity findMainDriverByCarId(final Long carId) {
        log.info("Find main driver by carId {}", carId);
        return driverRepository.findMainDriverByCarId(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Main driver not found."));
    }

    public DriverEntity findDriverByCustomerId(final Long customerId) {
        log.info("Find driver by customerId {}", customerId);
        return driverRepository.findDriverByCustomerId(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found."));
    }
}
