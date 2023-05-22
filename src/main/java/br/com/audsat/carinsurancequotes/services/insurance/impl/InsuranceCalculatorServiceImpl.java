package br.com.audsat.carinsurancequotes.services.insurance.impl;

import br.com.audsat.carinsurancequotes.builders.InsuranceCalculatorBuilder;
import br.com.audsat.carinsurancequotes.configurations.business.InsuranceRiskCalculatorConfiguration;
import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;
import br.com.audsat.carinsurancequotes.domains.entities.DriverEntity;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;
import br.com.audsat.carinsurancequotes.domains.pojo.InsuranceRiskCalculator;
import br.com.audsat.carinsurancequotes.services.driver.DriverQueriesService;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceCalculatorService;
import br.com.audsat.carinsurancequotes.services.insurance.risk.InsuranceRiskPercentageCalculatorService;
import br.com.audsat.carinsurancequotes.utils.BigDecimalUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InsuranceCalculatorServiceImpl implements InsuranceCalculatorService {

    private final InsuranceRiskCalculatorConfiguration insuranceRiskCalculatorConfiguration;
    private final List<InsuranceRiskPercentageCalculatorService> insuranceRiskPercentageCalculatorServices;
    private final DriverQueriesService driverQueriesService;

    public void calculateInsurance(final InsuranceEntity insuranceEntity) {
        log.info("Calculating insurance");

        final CarEntity carEntity = insuranceEntity.getCar();

        final DriverEntity mainDriverEntity = driverQueriesService
                .findMainDriverByCarId(carEntity.getId());

        final DriverEntity driverEntity = driverQueriesService
                .findDriverByCustomerId(insuranceEntity.getCustomer().getId());

        final InsuranceRiskCalculator insuranceRiskCalculator = InsuranceCalculatorBuilder
                .build(insuranceRiskCalculatorConfiguration, mainDriverEntity, driverEntity, carEntity);

        final BigDecimal riskPercentage = insuranceRiskPercentageCalculatorServices.stream()
                .map(impl -> impl.calculateRiskPercentage(insuranceRiskCalculator))
                .reduce(insuranceRiskCalculatorConfiguration.getBase(), BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);

        final BigDecimal amount = BigDecimalUtil.ruleOfThree(carEntity.getFipeValue(), riskPercentage)
                .setScale(2, RoundingMode.HALF_UP);

        insuranceEntity.setFipePercentage(riskPercentage);
        insuranceEntity.setAmount(amount);

        log.info("Calculated insurance");
    }
}
