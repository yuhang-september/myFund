package com.yuhang.trading.mapper.payment;

import com.yuhang.trading.entity.payment.AccountPaymentChannel;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 *
 * @author David
 * @Date 3/13/2024 5:49 PM
 */
public interface AccountPaymentChannelMapper {

    boolean insert(@Param("paymentChannel") AccountPaymentChannel accountPaymentChannel);
}
