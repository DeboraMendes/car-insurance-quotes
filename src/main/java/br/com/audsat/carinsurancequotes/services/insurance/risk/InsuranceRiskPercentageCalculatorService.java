package br.com.audsat.carinsurancequotes.services.insurance.risk;

import br.com.audsat.carinsurancequotes.domains.pojo.InsuranceRiskCalculator;

import java.math.BigDecimal;

public interface InsuranceRiskPercentageCalculatorService {
    BigDecimal calculateRiskPercentage(final InsuranceRiskCalculator insuranceRiskCalculator);
}
