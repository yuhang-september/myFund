package com.yuhang.trading.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 * A utility class to handle date and time.
 *
 * @author David
 * @date 2/27/2024 2:09 AM
 */
public class DateUtil {

    /**
     * The default formatted pattern.
     */
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * Getting a formatted date using a default pattern.
     *
     * @return String
     */
    public static String getFormattedDate() {
        return SDF.format(getCurrentDate());
    }

    /**
     * Getting a formatted date using a personalized pattern.
     *
     * @param pattern the personalized pattern
     * @return String
     */
    public static String getFormattedDate(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(getCurrentDate());
    }
}
