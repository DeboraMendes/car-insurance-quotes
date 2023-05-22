package br.com.audsat.carinsurancequotes.helper;

import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

public class InsuranceEntityHelperTest {
    public static void assertEquals(final InsuranceEntity expectedInsuranceEntity, final InsuranceEntity actualInsuranceEntity) {
        Assertions.assertEquals(expectedInsuranceEntity.getId(), actualInsuranceEntity.getId());

        if (Objects.nonNull(expectedInsuranceEntity.getCustomer()) || Objects.nonNull(actualInsuranceEntity.getCustomer())) {
            Assertions.assertEquals(expectedInsuranceEntity.getCustomer().getId(), actualInsuranceEntity.getCustomer().getId());
        }

        Assertions.assertEquals(expectedInsuranceEntity.getCreationDt(), actualInsuranceEntity.getCreationDt());

        Assertions.assertEquals(expectedInsuranceEntity.getUpdatedAt(), actualInsuranceEntity.getUpdatedAt());

        if (Objects.nonNull(expectedInsuranceEntity.getCar()) || Objects.nonNull(actualInsuranceEntity.getCar())) {
            Assertions.assertEquals(expectedInsuranceEntity.getCar().getId(), actualInsuranceEntity.getCar().getId());
        }

        Assertions.assertEquals(expectedInsuranceEntity.getIsActive(), actualInsuranceEntity.getIsActive());

        if (Objects.nonNull(expectedInsuranceEntity.getFipePercentage()) || Objects.nonNull(actualInsuranceEntity.getFipePercentage())) {
            Assertions.assertEquals(expectedInsuranceEntity.getFipePercentage(), actualInsuranceEntity.getFipePercentage());
        }

        if (Objects.nonNull(expectedInsuranceEntity.getAmount()) || Objects.nonNull(actualInsuranceEntity.getAmount())) {
            BigDecimalHelperTest.assertEquals(expectedInsuranceEntity.getAmount(), actualInsuranceEntity.getAmount());
        }
    }
}
