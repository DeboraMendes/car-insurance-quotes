package br.com.audsat.carinsurancequotes.services.insurance.risk.impl;

import br.com.audsat.carinsurancequotes.domains.pojo.InsuranceRiskCalculator;
import br.com.audsat.carinsurancequotes.services.insurance.risk.InsuranceRiskPercentageCalculatorService;
import br.com.audsat.carinsurancequotes.utils.IntegerUtil;
import br.com.audsat.carinsurancequotes.utils.LocalDateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainDriverInsuranceRiskPercentageCalculatorServiceImpl implements InsuranceRiskPercentageCalculatorService {
    public BigDecimal calculateRiskPercentage(final InsuranceRiskCalculator insuranceRiskCalculator) {
        log.info("Calculating for main driver risk");

        final Integer minAge = insuranceRiskCalculator.getInsuranceRiskCalculatorConfiguration().getMinAge();
        final Integer maxAge = insuranceRiskCalculator.getInsuranceRiskCalculatorConfiguration().getMaxAge();
        final Integer yearsOld = LocalDateUtil.calculateYearsOld(insuranceRiskCalculator.getMainDriver().getBirthdate());

        if (IntegerUtil.isBetween(yearsOld, minAge, maxAge)) {
            return insuranceRiskCalculator.getInsuranceRiskCalculatorConfiguration().getIncrement();
        }

        return BigDecimal.ZERO;
    }
}
