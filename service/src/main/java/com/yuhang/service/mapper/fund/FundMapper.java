package com.yuhang.service.mapper.fund;

import com.yuhang.service.entity.fund.Fund;

public interface FundMapper {

    public Fund selectByFundCode(String fundCode);
}
