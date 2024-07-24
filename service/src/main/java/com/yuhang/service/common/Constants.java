package com.yuhang.service.common;

/**
 * Description:
 *
 * @author David
 * 2/28/2024 11:58 PM
 */
public class Constants {

    public static final String DICTIONARY = "dictionary";

    public static final String DICTIONARY_ITEM = "dictionaryItem";

    public static final String PROFESSION = "profession";

    public static final String CERTIFICATION_TYPE = "certificationType";

    public static final String BANK = "bank";

    public static final int PAYMENT_CHANNEL_STATUS_ACTIVE = 0;
    public static final int PAYMENT_CHANNEL_STATUS_FROZEN = 1;
    public static final int PAYMENT_CHANNEL_STATUS_INACTIVE = 2;

    public static final String TRADE_TYPE_BUY = "T1";
    public static final String TRADE_TYPE_REDEEM = "T2";
    public static final String TRADE_TYPE_CONVERT = "T3";

    public static final String TRADE_BUSINESS_TYPE_BUY = "01";
    public static final String TRADE_BUSINESS_TYPE_REDEEM = "02";
    public static final String TRADE_BUSINESS_TYPE_CONVERT = "03";

    public static final int TRADE_REQUEST_STATUS_ORDER = 0;
    public static final int TRADE_REQUEST_STATUS_SUCCESS = 1;
    public static final int TRADE_REQUEST_STATUS_FAIL = 2;
    public static final int TRADE_REQUEST_STATUS_PART_SUCCESS = 3;
}
