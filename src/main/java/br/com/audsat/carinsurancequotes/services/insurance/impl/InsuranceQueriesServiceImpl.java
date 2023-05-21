package br.com.audsat.carinsurancequotes.services.insurance.impl;

import br.com.audsat.carinsurancequotes.adapters.CarDTOAdapter;
import br.com.audsat.carinsurancequotes.adapters.CustomerDTOAdapter;
import br.com.audsat.carinsurancequotes.adapters.DriverDTOAdapter;
import br.com.audsat.carinsurancequotes.adapters.InsuranceQueryResponseDTOAdapter;
import br.com.audsat.carinsurancequotes.domains.dto.CarDTO;
import br.com.audsat.carinsurancequotes.domains.dto.CustomerDTO;
import br.com.audsat.carinsurancequotes.domains.dto.DriverDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceQueryResponseDTO;
import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;
import br.com.audsat.carinsurancequotes.domains.entities.CustomerEntity;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;
import br.com.audsat.carinsurancequotes.exceptions.ResourceNotFoundException;
import br.com.audsat.carinsurancequotes.repositories.InsuranceRepository;
import br.com.audsat.carinsurancequotes.services.car.CarQueriesService;
import br.com.audsat.carinsurancequotes.services.claim.ClaimQueriesService;
import br.com.audsat.carinsurancequotes.services.customer.CustomerQueriesService;
import br.com.audsat.carinsurancequotes.services.driver.DriverQueriesService;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceQueriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class InsuranceQueriesServiceImpl implements InsuranceQueriesService {

    private final InsuranceRepository insuranceRepository;
    private final CustomerQueriesService customerQueriesService;
    private final CarQueriesService carQueriesService;
    private final DriverQueriesService driverQueriesService;
    private final ClaimQueriesService claimQueriesService;

    @Override
    public InsuranceQueryResponseDTO findInsuranceById(final Long id) {
        log.info("Find insurance by id {}", id);

        final InsuranceEntity insuranceEntity = insuranceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insurance not found."));

        final CustomerEntity customerEntity = customerQueriesService.findCustomerById(insuranceEntity.getCustomer().getId());
        final CustomerDTO customerDTO = CustomerDTOAdapter.build(customerEntity);

        final CarEntity carEntity = carQueriesService.findCarById(insuranceEntity.getCar().getId());
        final CarDTO carDTO = CarDTOAdapter.build(carEntity);

        final Set<DriverDTO> driversDTO = driverQueriesService
                .findDriversByCarId(carEntity.getId())
                .stream()
                .map(DriverDTOAdapter::build)
                .collect(Collectors.toSet());
        carDTO.setDrivers(driversDTO);

        driversDTO.stream()
                .filter(d -> d.getId().equals(customerEntity.getDriver().getId()))
                .findFirst()
                .ifPresent(customerDriverDTO -> {
                    customerDTO.setDriver(customerDriverDTO);
                    customerDriverDTO.setHasClaim(claimQueriesService.existsClaimByDriverId(customerDriverDTO.getId()));
                });
        carDTO.setHasClaim(claimQueriesService.existsClaimByCarId(carEntity.getId()));

        log.info("Insurance found");

        return InsuranceQueryResponseDTOAdapter.build(insuranceEntity, customerDTO, carDTO);
    }
}
