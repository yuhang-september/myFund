package com.yuhang.trading.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The global exception handler.
 * All the response body is {@link JsonResult}.
 * Hide the original error as far as possible.
 *
 * @author David
 * @date 2024/2/27
 * */
@ControllerAdvice
public class ExceptionController {

    /**
     * If the exception is a {@link RuleException}, then use the relevant error code and message.
     * If the exception belongs to other types, use the error code {@link JsonResult#UNKNOWN}
     * */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult handleRuleException(Exception e) {
        if (e instanceof RuleException exception) {
            return JsonResult.generateResult(exception.getCode(), exception.getMessage());
        } else {
            return JsonResult.generateResult(JsonResult.UNKNOWN, e.getMessage());
        }
    }
}
