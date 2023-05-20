package br.com.audsat.carinsurancequotes.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateUtil {

    public static Integer calculateYearsOld(final LocalDate localDate) {
        return Period.between(localDate, LocalDate.now()).getYears();
    }

}
