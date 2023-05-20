package br.com.audsat.carinsurancequotes.services.insurance.impl;

import br.com.audsat.carinsurancequotes.adapters.InsuranceCreationResponseDTOAdapter;
import br.com.audsat.carinsurancequotes.builders.InsuranceEntityBuilder;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationRequestDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;
import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;
import br.com.audsat.carinsurancequotes.domains.entities.CustomerEntity;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;
import br.com.audsat.carinsurancequotes.repositories.InsuranceRepository;
import br.com.audsat.carinsurancequotes.services.car.CarQueriesService;
import br.com.audsat.carinsurancequotes.services.customer.CustomerQueriesService;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceCalculatorService;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceCreationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InsuranceCreationServiceImpl implements InsuranceCreationService {

    private final InsuranceRepository insuranceRepository;
    private final CustomerQueriesService customerQueriesService;
    private final CarQueriesService carQueriesService;
    private final InsuranceCalculatorService insuranceCalculatorService;

    @Override
    public InsuranceCreationResponseDTO createInsurance(final InsuranceCreationRequestDTO insuranceCreationRequestDTO) {
        log.info("Creating insurance customerId {}", insuranceCreationRequestDTO.getCustomerId());

        final CustomerEntity customerEntity = customerQueriesService
                .findCustomerById(insuranceCreationRequestDTO.getCustomerId());

        final CarEntity carEntity = carQueriesService
                .findCarById(insuranceCreationRequestDTO.getCarId());

        final Boolean active = insuranceCreationRequestDTO.getActive();

        InsuranceEntity insuranceEntity = InsuranceEntityBuilder.build(customerEntity, carEntity, active);

        insuranceCalculatorService.calculateInsurance(insuranceEntity);

        log.info("Saving insurance");

        insuranceEntity = insuranceRepository.save(insuranceEntity);

        log.info("Created insurance");

        return InsuranceCreationResponseDTOAdapter.build(insuranceEntity);
    }
}
