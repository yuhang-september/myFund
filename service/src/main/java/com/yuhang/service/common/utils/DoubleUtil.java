package com.yuhang.service.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Description:
 * A utility class to handle Double calculation.
 *
 * @author David
 * 2/27/2024 2:09 AM
 */
public class DoubleUtil {

    public static double divide(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.divide(b2, 2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double add(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.add(b2).doubleValue();
    }
    public static double subtract(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.subtract(b2).doubleValue();
    }

}
