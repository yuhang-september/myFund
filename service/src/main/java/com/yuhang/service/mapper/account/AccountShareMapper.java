package com.yuhang.service.mapper.account;

import com.yuhang.service.entity.account.AccountShare;
import org.apache.ibatis.annotations.Param;

public interface AccountShareMapper {

    void insert(@Param("share") AccountShare share);

    AccountShare select(@Param("tradeAccountId") String tradeAccountId, @Param("fundCode") String fundCode, @Param("paymentChannel") String paymentChannel);

    void update(@Param("share") AccountShare share);
}
