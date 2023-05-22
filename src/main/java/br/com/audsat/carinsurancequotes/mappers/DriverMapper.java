package br.com.audsat.carinsurancequotes.mappers;

import br.com.audsat.carinsurancequotes.domains.dto.DriverDTO;
import br.com.audsat.carinsurancequotes.domains.pojo.IDriverEntity;
import br.com.audsat.carinsurancequotes.utils.LocalDateUtil;

public interface DriverMapper {
    static DriverDTO toDto(final IDriverEntity driverEntity) {
        return DriverDTO.builder()
                .id(driverEntity.getId())
                .document(driverEntity.getDocument())
                .birthdate(driverEntity.getBirthdate())
                .yearsOld(LocalDateUtil.calculateYearsOld(driverEntity.getBirthdate()))
                .mainDriver(driverEntity.getMainDriver())
                .build();
    }
}
