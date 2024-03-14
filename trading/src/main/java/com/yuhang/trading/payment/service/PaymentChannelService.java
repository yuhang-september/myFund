package com.yuhang.trading.payment.service;

import com.yuhang.trading.common.JsonResult;
import com.yuhang.trading.common.RuleException;
import com.yuhang.trading.common.utils.SessionUtil;
import com.yuhang.trading.entity.account.Account;
import com.yuhang.trading.entity.payment.AccountPaymentChannel;
import com.yuhang.trading.entity.payment.BankCard;
import com.yuhang.trading.entity.payment.PaymentChannel;
import com.yuhang.trading.mapper.payment.AccountPaymentChannelMapper;
import com.yuhang.trading.mapper.payment.PaymentChannelMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Description:
 *
 * @author David
 * @Date 2/29/2024 9:43 PM
 */
@Service
public class PaymentChannelService {

    @Resource
    PaymentChannelMapper paymentChannelMapper;

    @Resource
    AccountPaymentChannelMapper accountPaymentChannelMapper;

    public boolean savePaymentChannel(BankCard bankCard) throws RuleException {
        AccountPaymentChannel accountPaymentChannel = new AccountPaymentChannel();
        accountPaymentChannel.setId(UUID.randomUUID().toString().replaceAll("-",""));
        Account accountInfo = SessionUtil.getAccountInfo();
        if (accountInfo == null) {
            throw new RuleException(JsonResult.UNKNOWN, "The session is timeout, please log in again.");
        }
        accountPaymentChannel.setAccountNo(accountInfo.getId());
        accountPaymentChannel.setBankAccountNo(bankCard.getBankAccountNo());
        accountPaymentChannel.setPaymentChannel(getResponsiblePaymentChannel(bankCard.getBank()));
        return accountPaymentChannelMapper.insert(accountPaymentChannel);
    }

    private String getResponsiblePaymentChannel(String bank) throws RuleException {
        PaymentChannel paymentChannel = paymentChannelMapper.selectByBank(bank);
        if (paymentChannel == null) {
            throw new RuleException(JsonResult.UNKNOWN, "Please check your bank card information.");
        }
        return paymentChannel.getPaymentChannel();
    }
}
