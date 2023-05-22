package br.com.audsat.carinsurancequotes.mappers;

import br.com.audsat.carinsurancequotes.domains.dto.CarDTO;
import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;

public interface CarMapper {
    static CarDTO toDto(final CarEntity carEntity) {
        return CarDTO.builder()
                .id(carEntity.getId())
                .model(carEntity.getModel())
                .manufacturer(carEntity.getManufacturer())
                .year(carEntity.getYear())
                .fipeValue(carEntity.getFipeValue())
                .build();
    }
}
