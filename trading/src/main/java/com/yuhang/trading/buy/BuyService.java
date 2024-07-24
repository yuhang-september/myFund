package com.yuhang.trading.buy;

import com.yuhang.service.common.Constants;
import com.yuhang.service.common.utils.DateUtil;
import com.yuhang.service.common.utils.RequestIdGenerator;
import com.yuhang.service.entity.request.TradeRequest;
import com.yuhang.trading.rabbitmq.Sender;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author David
 * 5/17/2024
 */
@Service
public class BuyService {

    @Resource
    Sender sender;

    public void buy(TradeRequest request) {
        request.setTradeRequestId(RequestIdGenerator.getRequestId());
        Date currentDate = DateUtil.getCurrentDate();
        request.setCreateTime(currentDate);
        request.setLastUpdateTime(currentDate);
        request.setStatus(Constants.TRADE_REQUEST_STATUS_ORDER);
        request.setType(Constants.TRADE_TYPE_BUY);
        sender.sendToBuyQueue(request);
    }

}
