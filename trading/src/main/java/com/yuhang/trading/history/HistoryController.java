package com.yuhang.trading.history;

import com.yuhang.service.entity.history.HistoryRequest;
import com.yuhang.service.entity.request.TradeRequest;
import com.yuhang.trading.common.JsonResult;
import com.yuhang.trading.common.RuleException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David
 * 5/17/2024
 */
@Tag(name = "History Controller", description = "The controller is to query the trading history.")
@RestController
@RequestMapping("/history")
public class HistoryController {

    @Resource
    private HistoryService historyService;

    public JsonResult<List<TradeRequest>> queryTradeHistories(HistoryRequest historyRequest) throws RuleException {
        if (historyRequest == null || withNoAttribute(historyRequest)) {
            return new JsonResult<>(new ArrayList<List<TradeRequest>>());
        }
        return new JsonResult<>(historyService.getHistory(historyRequest));
    }

    private boolean withNoAttribute(Object request) throws RuleException {
        Field[] declaredFields = request.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            Class<?> type = field.getType();
            try {
                Object fieldValue = field.get(field.getName());
                if (fieldValue == null || (type.equals(String.class) && StringUtils.isBlank((String) fieldValue))) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                throw new RuleException(JsonResult.UNKNOWN, e.getMessage());
            }
        }
        return true;
    }
}
