package com.yuhang.trading.buy;

import com.yuhang.trading.common.Constants;
import com.yuhang.trading.common.utils.DateUtil;
import com.yuhang.trading.entity.request.TradeRequest;
import com.yuhang.trading.mapper.buy.BuyMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author David
 * 5/17/2024
 */
@Service
public class BuyService {

    @Resource
    BuyMapper buyMapper;

    public void buy(TradeRequest request) {
        String tradeRequestId = UUID.randomUUID().toString().replaceAll("-", "");
        request.setTradeRequestId(tradeRequestId);
        Date currentDate = DateUtil.getCurrentDate();
        request.setCreateTime(currentDate);
        request.setLastUpdateTime(currentDate);
        request.setStatus(Constants.TRADE_REQUEST_STATUS_ORDER);
        request.setType(Constants.TRADE_TYPE_BUY);
        buyMapper.insert(request);
    }

}
