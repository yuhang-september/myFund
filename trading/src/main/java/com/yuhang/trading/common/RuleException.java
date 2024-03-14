package com.yuhang.trading.common;

import lombok.Data;

/**
 * The personalized exception.
 * @author David
 * @date 2024/2/27
 * */
@Data
public class RuleException extends Exception {

    private String code;

    private String message;

    public RuleException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
