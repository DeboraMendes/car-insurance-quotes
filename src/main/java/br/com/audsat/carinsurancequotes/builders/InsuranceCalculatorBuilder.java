package br.com.audsat.carinsurancequotes.builders;

import br.com.audsat.carinsurancequotes.configurations.business.InsuranceRiskCalculatorConfiguration;
import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;
import br.com.audsat.carinsurancequotes.domains.entities.DriverEntity;
import br.com.audsat.carinsurancequotes.domains.pojo.InsuranceRiskCalculator;

public interface InsuranceCalculatorBuilder {
    static InsuranceRiskCalculator build(final InsuranceRiskCalculatorConfiguration insuranceRiskCalculatorConfiguration,
                                         final DriverEntity mainDriverEntity,
                                         final DriverEntity driverEntity,
                                         final CarEntity carEntity) {
        return InsuranceRiskCalculator.builder()
                .insuranceRiskCalculatorConfiguration(insuranceRiskCalculatorConfiguration)
                .mainDriver(mainDriverEntity)
                .driver(driverEntity)
                .car(carEntity)
                .build();

    }
}
