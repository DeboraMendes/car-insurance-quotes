package br.com.audsat.carinsurancequotes.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BigDecimalUtil {

    public static BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    public static BigDecimal ruleOfThree(final BigDecimal amount,
                                         final BigDecimal percentage) {
        return amount
                .multiply(percentage)
                .divide(BigDecimalUtil.ONE_HUNDRED);
    }
}
