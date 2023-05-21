package br.com.audsat.carinsurancequotes.builder;

import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;
import br.com.audsat.carinsurancequotes.domains.entities.CustomerEntity;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;

public class InsuranceEntityBuilderTest {
    public static InsuranceEntity build() {
        return InsuranceEntity.builder()
                .customer(new CustomerEntity())
                .car(new CarEntity())
                .isActive(Boolean.TRUE)
                .build();
    }
}
