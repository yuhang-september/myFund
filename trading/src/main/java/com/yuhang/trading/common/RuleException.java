package com.yuhang.trading.common;

import lombok.Data;

import java.io.Serial;

/**
 * The personalized exception.
 * @author David
 * 2024/2/27
 * */
@Data
public class RuleException extends Exception {

    @Serial
    private static final long serialVersionUID = -5780849272248746428L;
    private String code;

    private String message;

    public RuleException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
