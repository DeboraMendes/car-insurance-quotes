package br.com.audsat.carinsurancequotes.configurations.business;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@Getter
@Setter
@ConfigurationProperties(prefix = "insurance-risk")
public class InsuranceRiskCalculatorConfiguration {
    private BigDecimal base;
    private BigDecimal increment;
    private Integer minAge;
    private Integer maxAge;
}
