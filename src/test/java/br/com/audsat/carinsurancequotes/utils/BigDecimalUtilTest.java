package br.com.audsat.carinsurancequotes.utils;

import br.com.audsat.carinsurancequotes.helper.BigDecimalHelperTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalUtilTest {

    @Test
    public void ruleOfThree() {
        final BigDecimal amount = BigDecimalUtil.ruleOfThree(BigDecimal.valueOf(15000), BigDecimal.valueOf(10));
        BigDecimalHelperTest.assertEquals(BigDecimal.valueOf(1500), amount);
    }
}