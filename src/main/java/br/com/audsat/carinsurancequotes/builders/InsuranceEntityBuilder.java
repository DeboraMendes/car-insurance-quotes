package br.com.audsat.carinsurancequotes.builders;

import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;
import br.com.audsat.carinsurancequotes.domains.entities.CustomerEntity;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;

public interface InsuranceEntityBuilder {
    static InsuranceEntity build(final CustomerEntity customerEntity,
                                 final CarEntity carEntity,
                                 final Boolean active) {
        return InsuranceEntity.builder()
                .customer(customerEntity)
                .car(carEntity)
                .isActive(active)
                .build();
    }
}
