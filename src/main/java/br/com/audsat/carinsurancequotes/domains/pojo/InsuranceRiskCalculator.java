package br.com.audsat.carinsurancequotes.domains.pojo;

import br.com.audsat.carinsurancequotes.configurations.business.InsuranceRiskCalculatorConfiguration;
import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;
import br.com.audsat.carinsurancequotes.domains.entities.DriverEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InsuranceRiskCalculator {
    private InsuranceRiskCalculatorConfiguration insuranceRiskCalculatorConfiguration;
    private DriverEntity mainDriver;
    private DriverEntity driver;
    private CarEntity car;
}
