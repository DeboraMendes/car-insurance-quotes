package br.com.audsat.carinsurancequotes.adapters;

import br.com.audsat.carinsurancequotes.domains.dto.DriverDTO;
import br.com.audsat.carinsurancequotes.domains.pojo.IDriverEntity;
import br.com.audsat.carinsurancequotes.utils.LocalDateUtil;

public interface DriverDTOAdapter {
    static DriverDTO build(final IDriverEntity driverEntity) {
        return DriverDTO.builder()
                .id(driverEntity.getId())
                .document(driverEntity.getDocument())
                .birthdate(driverEntity.getBirthdate())
                .yearsOld(LocalDateUtil.calculateYearsOld(driverEntity.getBirthdate()))
                .mainDriver(driverEntity.getMainDriver())
                .build();
    }
}
