package br.com.audsat.carinsurancequotes.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BigDecimalUtilTest {

    @Test
    public void ruleOfThree() {
        final BigDecimal amount = BigDecimalUtil.ruleOfThree(BigDecimal.valueOf(15000), BigDecimal.valueOf(10));
        Assertions.assertEquals(0, BigDecimal.valueOf(1500).compareTo(amount));
    }
}