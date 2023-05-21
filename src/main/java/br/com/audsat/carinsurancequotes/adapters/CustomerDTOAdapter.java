package br.com.audsat.carinsurancequotes.adapters;

import br.com.audsat.carinsurancequotes.domains.dto.CustomerDTO;
import br.com.audsat.carinsurancequotes.domains.entities.CustomerEntity;

public interface CustomerDTOAdapter {
    static CustomerDTO build(final CustomerEntity customerEntity) {
        return CustomerDTO.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .build();
    }
}
