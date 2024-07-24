package com.yuhang.rabbitmq;

import com.yuhang.service.common.Constants;
import com.yuhang.service.common.utils.DateUtil;
import com.yuhang.service.common.utils.DoubleUtil;
import com.yuhang.service.common.utils.RequestIdGenerator;
import com.yuhang.service.entity.account.AccountShare;
import com.yuhang.service.entity.fund.Nav;
import com.yuhang.service.entity.request.TradeBusiness;
import com.yuhang.service.entity.request.TradeRequest;
import com.yuhang.service.mapper.account.AccountShareMapper;
import com.yuhang.service.mapper.fund.NavMapper;
import com.yuhang.service.mapper.tradebusiness.TradeBusinessMapper;
import com.yuhang.service.mapper.traderequest.TradeRequestMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author David
 * 2024-07-17 2:36 a.m.
 */
@Component
@Slf4j
public class BuyReceiver {

    @Resource
    TradeRequestMapper tradeRequestMapper;
    @Resource
    TradeBusinessMapper businessMapper;
    @Resource
    NavMapper navMapper;
    @Resource
    AccountShareMapper shareMapper;

    @Transactional(rollbackFor = Exception.class)
    public void receiveMessage(TradeRequest tradeRequest) {
        log.debug("[BuyReceiver] received tradeRequest: {}]", tradeRequest);
        tradeRequestMapper.insert(tradeRequest);
        TradeBusiness business = createTradeBusiness(tradeRequest);
        log.debug("[BuyReceiver] generated tradeBusiness: {}]", business);
        businessMapper.insert(business);
        AccountShare share = shareMapper.select(tradeRequest.getTradeAccountId(), tradeRequest.getFundCode(), tradeRequest.getPaymentChannel());
        if (share == null) {
            share = createAccountShare(tradeRequest, business);
            log.debug("[BuyReceiver] generated a new AccountShare record: {}]", share);
            shareMapper.insert(share);
        } else {
            share.setShare(DoubleUtil.add(share.getShare(), business.getShare()));
            share.setLastUpdateTime(DateUtil.getCurrentDate());
            log.debug("[BuyReceiver] updated an existing AccountShare record: {}]", share);
            shareMapper.update(share);
        }
    }

    private AccountShare createAccountShare(TradeRequest tradeRequest, TradeBusiness business) {
        AccountShare share = new AccountShare();
        share.setShareId(RequestIdGenerator.getRequestId());
        share.setAccountId(tradeRequest.getTradeAccountId());
        share.setFundCode(tradeRequest.getFundCode());
        share.setShare(business.getShare());
        share.setPaymentChannel(tradeRequest.getPaymentChannel());
        Date currentDate = DateUtil.getCurrentDate();
        share.setCreateTime(currentDate);
        share.setLastUpdateTime(currentDate);
        return share;
    }

    private TradeBusiness createTradeBusiness(TradeRequest tradeRequest) {
        TradeBusiness business = new TradeBusiness();
        business.setTradeRequestId(tradeRequest.getTradeRequestId());
        business.setFundCode(tradeRequest.getFundCode());
        business.setAmount(tradeRequest.getApplicationAmount());
        business.setType(Constants.TRADE_BUSINESS_TYPE_BUY);
        business.setStatus(Constants.TRADE_REQUEST_STATUS_SUCCESS);
        Date currentDate = DateUtil.getCurrentDate();
        business.setCreateTime(currentDate);
        business.setLastUpdateTime(currentDate);
        business.setBusinessId(RequestIdGenerator.getRequestId());
        business.setShare(calculateShare(tradeRequest.getFundCode(), tradeRequest.getApplicationAmount()));
        return business;
    }

    private double calculateShare(String fundCode, double applicationAmount) {
        Nav nav = navMapper.selectLastNav(fundCode);
        return DoubleUtil.divide(applicationAmount, nav.getNav());
    }
}
