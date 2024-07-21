package com.yuhang.trading.mapper.payment;

import com.yuhang.service.entity.payment.PaymentChannel;

/**
 * Description:
 *
 * @author David
 * @Date 2/29/2024 10:36 PM
 */
public interface PaymentChannelMapper {

    public PaymentChannel selectByBank(String bank);
}
