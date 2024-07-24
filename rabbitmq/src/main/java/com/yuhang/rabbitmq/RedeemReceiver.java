package com.yuhang.rabbitmq;

import com.yuhang.service.common.Constants;
import com.yuhang.service.common.JsonResult;
import com.yuhang.service.common.RuleException;
import com.yuhang.service.common.utils.DateUtil;
import com.yuhang.service.common.utils.DoubleUtil;
import com.yuhang.service.common.utils.RequestIdGenerator;
import com.yuhang.service.entity.account.AccountShare;
import com.yuhang.service.entity.request.TradeBusiness;
import com.yuhang.service.entity.request.TradeRequest;
import com.yuhang.service.mapper.account.AccountShareMapper;
import com.yuhang.service.mapper.tradebusiness.TradeBusinessMapper;
import com.yuhang.service.mapper.traderequest.TradeRequestMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author David
 * 2024-07-17 2:53 a.m.
 */
@Component
@Slf4j
public class RedeemReceiver {

    @Resource
    TradeRequestMapper tradeRequestMapper;
    @Resource
    TradeBusinessMapper businessMapper;
    @Resource
    AccountShareMapper shareMapper;

    @Transactional(rollbackFor = Exception.class)
    public void receiveMessage(TradeRequest tradeRequest) throws RuleException {
        log.debug("[RedeemReceiver] received tradeRequest: {}]", tradeRequest);
        tradeRequestMapper.insert(tradeRequest);
        TradeBusiness business = createTradeBusiness(tradeRequest);
        log.debug("[RedeemReceiver] generated tradeBusiness: {}]", business);
        businessMapper.insert(business);
        AccountShare share = shareMapper.select(tradeRequest.getTradeAccountId(), tradeRequest.getFundCode(), tradeRequest.getPaymentChannel());
        if (share == null) {
            log.debug("[RedeemReceiver] can not find an existing AccountShare record, accountId:{}, fundCode:{}, paymentChannel:{}]", tradeRequest.getTradeAccountId(), tradeRequest.getFundCode(), tradeRequest.getPaymentChannel());
            throw new RuleException(JsonResult.TRADING_ERROR, "Sorry, you don't have existing share record.");
        } else {
            share.setShare(DoubleUtil.subtract(share.getShare(), business.getShare()));
            share.setLastUpdateTime(DateUtil.getCurrentDate());
            log.debug("[RedeemReceiver] updated an existing AccountShare record: {}]", share);
            shareMapper.update(share);
        }
    }

    private TradeBusiness createTradeBusiness(TradeRequest tradeRequest) {
        TradeBusiness business = new TradeBusiness();
        business.setTradeRequestId(tradeRequest.getTradeRequestId());
        business.setFundCode(tradeRequest.getFundCode());
        business.setShare(tradeRequest.getShare());
        business.setType(Constants.TRADE_BUSINESS_TYPE_REDEEM);
        business.setStatus(Constants.TRADE_REQUEST_STATUS_SUCCESS);
        Date currentDate = DateUtil.getCurrentDate();
        business.setCreateTime(currentDate);
        business.setLastUpdateTime(currentDate);
        business.setBusinessId(RequestIdGenerator.getRequestId());
        return business;
    }
}
