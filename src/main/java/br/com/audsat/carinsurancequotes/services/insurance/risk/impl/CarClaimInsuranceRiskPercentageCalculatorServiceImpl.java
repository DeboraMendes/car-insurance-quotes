package br.com.audsat.carinsurancequotes.services.insurance.risk.impl;

import br.com.audsat.carinsurancequotes.domains.pojo.InsuranceRiskCalculator;
import br.com.audsat.carinsurancequotes.services.claim.ClaimQueriesService;
import br.com.audsat.carinsurancequotes.services.insurance.risk.InsuranceRiskPercentageCalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarClaimInsuranceRiskPercentageCalculatorServiceImpl implements InsuranceRiskPercentageCalculatorService {

    private final ClaimQueriesService claimQueriesService;

    public BigDecimal calculateRiskPercentage(final InsuranceRiskCalculator insuranceRiskCalculator) {
        log.info("Calculating for car claim risk");

        final Boolean existsClaim = claimQueriesService
                .existsClaimByCarId(insuranceRiskCalculator.getCar().getId());

        if (existsClaim) {
            return insuranceRiskCalculator.getInsuranceRiskCalculatorConfiguration().getIncrement();
        }

        return BigDecimal.ZERO;
    }
}
