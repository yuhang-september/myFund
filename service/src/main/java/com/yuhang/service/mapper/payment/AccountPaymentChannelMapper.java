package com.yuhang.service.mapper.payment;

import com.yuhang.service.entity.payment.AccountPaymentChannel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @author David
 * @Date 3/13/2024 5:49 PM
 */
public interface AccountPaymentChannelMapper {

    boolean insert(@Param("paymentChannel") AccountPaymentChannel accountPaymentChannel);

    List<AccountPaymentChannel> queryByAccountNo(String accountNo);
}
