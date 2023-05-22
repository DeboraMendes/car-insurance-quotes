package br.com.audsat.carinsurancequotes.helper;

import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class BigDecimalHelperTest {
    public static void assertEquals(final BigDecimal expectedBigDecimal,
                                    final BigDecimal actualBigDecimal) {
        Assertions.assertEquals(0, expectedBigDecimal.compareTo(actualBigDecimal));
    }
}
