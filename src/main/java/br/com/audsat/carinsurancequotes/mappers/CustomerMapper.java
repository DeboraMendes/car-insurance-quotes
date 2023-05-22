package br.com.audsat.carinsurancequotes.mappers;

import br.com.audsat.carinsurancequotes.domains.dto.CustomerDTO;
import br.com.audsat.carinsurancequotes.domains.entities.CustomerEntity;

public interface CustomerMapper {
    static CustomerDTO toDto(final CustomerEntity customerEntity) {
        return CustomerDTO.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .build();
    }
}
