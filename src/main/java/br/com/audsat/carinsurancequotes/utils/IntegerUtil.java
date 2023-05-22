package br.com.audsat.carinsurancequotes.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IntegerUtil {

    public static boolean isGreaterThanOrEqualTo(final Integer integer, final Integer anotherInteger) {
        return integer.compareTo(anotherInteger) >= 0;
    }

    public static boolean isLessThanOrEqualTo(final Integer integer, final Integer anotherInteger) {
        return integer.compareTo(anotherInteger) <= 0;
    }

    public static boolean isBetween(final Integer integer, final Integer startInteger, final Integer endInteger) {
        return IntegerUtil.isGreaterThanOrEqualTo(integer, startInteger) && IntegerUtil.isLessThanOrEqualTo(integer, endInteger);
    }

}
