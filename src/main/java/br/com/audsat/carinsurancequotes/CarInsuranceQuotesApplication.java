package br.com.audsat.carinsurancequotes;

import br.com.audsat.carinsurancequotes.configurations.business.InsuranceRiskCalculatorConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {InsuranceRiskCalculatorConfiguration.class})
public class CarInsuranceQuotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarInsuranceQuotesApplication.class, args);
    }

}
