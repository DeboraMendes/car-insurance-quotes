package br.com.audsat.carinsurancequotes.services.insurance.impl;

import br.com.audsat.carinsurancequotes.builder.InsuranceEntityBuilderTest;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;
import br.com.audsat.carinsurancequotes.exceptions.BusinessException;
import br.com.audsat.carinsurancequotes.helper.InsuranceEntityHelperTest;
import br.com.audsat.carinsurancequotes.repositories.InsuranceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class InsuranceStatusUpdaterServiceImplTest {

    @InjectMocks
    private InsuranceStatusUpdaterServiceImpl insuranceStatusUpdaterService;

    @Mock
    private InsuranceRepository insuranceRepository;

    @Test
    public void updateInsuranceStatusByIdWithSuccessfulResult() {
        final Long id = 1L;
        final Boolean active = Boolean.FALSE;

        final InsuranceEntity expectedInsuranceEntity = InsuranceEntityBuilderTest.build();
        expectedInsuranceEntity.setId(id);
        expectedInsuranceEntity.setIsActive(active);

        final InsuranceEntity insuranceEntity = InsuranceEntityBuilderTest.build();
        insuranceEntity.setId(id);
        insuranceEntity.setIsActive(!expectedInsuranceEntity.getIsActive());

        ArgumentCaptor<InsuranceEntity> actualInsuranceEntity = ArgumentCaptor.forClass(InsuranceEntity.class);

        Mockito.when(insuranceRepository.findById(id))
                .thenReturn(Optional.of(insuranceEntity));

        insuranceStatusUpdaterService.updateInsuranceStatusById(id, active);

        Mockito.verify(insuranceRepository, Mockito.times(1))
                .save(actualInsuranceEntity.capture());

        InsuranceEntityHelperTest.assertEquals(expectedInsuranceEntity, actualInsuranceEntity.getValue());
    }

    @Test
    public void updateInsuranceStatusByIdWithUnsuccessfulResult() {
        final Long id = 1L;
        final Boolean active = Boolean.FALSE;

        final BusinessException expectedBusinessException = new BusinessException("The insurance is already in this status.");

        final InsuranceEntity insuranceEntity = InsuranceEntityBuilderTest.build();
        insuranceEntity.setId(id);
        insuranceEntity.setIsActive(active);

        Mockito.when(insuranceRepository.findById(id))
                .thenReturn(Optional.of(insuranceEntity));

        final BusinessException actualBusinessException = Assertions.assertThrows(BusinessException.class, () ->
                insuranceStatusUpdaterService.updateInsuranceStatusById(id, active)
        );

        Mockito.verify(insuranceRepository, Mockito.times(0))
                .save(Mockito.any());

        Assertions.assertEquals(expectedBusinessException.getMessage(), actualBusinessException.getMessage());
    }

}