package com.yuhang.service.common.utils;

import java.util.UUID;

/**
 * @author David
 * 2024-07-24 12:39 a.m.
 */
public class RequestIdGenerator {

    public static String getRequestId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
