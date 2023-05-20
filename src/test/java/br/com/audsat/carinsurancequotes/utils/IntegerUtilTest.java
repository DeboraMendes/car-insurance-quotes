package br.com.audsat.carinsurancequotes.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerUtilTest {

    @Test
    public void isGreaterThanOrEqualTo() {
        Assertions.assertFalse(IntegerUtil.isGreaterThanOrEqualTo(1, 2));
        Assertions.assertTrue(IntegerUtil.isGreaterThanOrEqualTo(2, 2));
        Assertions.assertTrue(IntegerUtil.isGreaterThanOrEqualTo(3, 2));
    }

    @Test
    public void isLessThanOrEqualTo() {
        Assertions.assertTrue(IntegerUtil.isLessThanOrEqualTo(1, 2));
        Assertions.assertTrue(IntegerUtil.isLessThanOrEqualTo(2, 2));
        Assertions.assertFalse(IntegerUtil.isLessThanOrEqualTo(3, 2));
    }

    @Test
    public void isBetween() {
        Assertions.assertFalse(IntegerUtil.isBetween(1, 2, 4));
        Assertions.assertTrue(IntegerUtil.isBetween(2, 2, 4));
        Assertions.assertTrue(IntegerUtil.isBetween(3, 2, 4));
        Assertions.assertTrue(IntegerUtil.isBetween(4, 2, 4));
        Assertions.assertFalse(IntegerUtil.isBetween(5, 2, 4));
    }
}