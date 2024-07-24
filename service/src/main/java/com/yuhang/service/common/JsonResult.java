package com.yuhang.service.common;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Description:
 * A wrapped class to return to web.
 *
 * @author David
 * 2/27/2024 2:09 AM
 */
@Data
public class JsonResult<T> {

    public static final String SUCCESS = "0000";
    public static final String ACCOUNT_ERROR = "0001";
    public static final String TRADING_ERROR = "0002";
    public static final String UNKNOWN = "XXXX";

    public static final String SUCCESS_MESSAGE = "Success";

    /**
     * error code
     * 0000: success
     * 0001: account error
     * 0002: trading error
     * 0003: others
     */
    private String code;

    /**
     * Describe the error message.
     */
    private String message;

    /**
     * The main content.
     */
    private Object content;

    public JsonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @param content the main return content.
     *                When there is only one parameter and the type is Object, we reckon that we have handled a request successfully.
     */
    public JsonResult(Object content) {
        this.code = SUCCESS;
        this.message = SUCCESS_MESSAGE;
        this.content = content;
    }

    public static JsonResult<Object> generateResult(String code, String message) {
        return StringUtils.equals(code, SUCCESS) ? generateResult(code) : new JsonResult<>(code, message);
    }

    public static JsonResult<Object> generateResult(String code) {
        return new JsonResult<>(code, SUCCESS_MESSAGE);
    }
}
