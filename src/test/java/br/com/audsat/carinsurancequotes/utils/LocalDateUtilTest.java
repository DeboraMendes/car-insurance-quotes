package br.com.audsat.carinsurancequotes.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LocalDateUtilTest {

    @Test
    public void calculateYearsOld() {
        final Integer years = 10;
        final LocalDate localDateYearBefore = LocalDate.now().minusYears(years);
        final Integer yearsOld = LocalDateUtil.calculateYearsOld(localDateYearBefore);
        Assertions.assertEquals(years, yearsOld);
    }
}