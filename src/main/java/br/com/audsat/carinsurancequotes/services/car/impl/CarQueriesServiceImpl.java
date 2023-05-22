package br.com.audsat.carinsurancequotes.services.car.impl;

import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;
import br.com.audsat.carinsurancequotes.exceptions.ResourceNotFoundException;
import br.com.audsat.carinsurancequotes.repositories.CarRepository;
import br.com.audsat.carinsurancequotes.services.car.CarQueriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarQueriesServiceImpl implements CarQueriesService {

    private final CarRepository carRepository;

    public CarEntity findCarById(final Long id) {
        log.info("Find car by id {}", id);
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found."));
    }
}
