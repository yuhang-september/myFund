package com.yuhang.service.mapper.fund;

import com.yuhang.service.entity.fund.Nav;

public interface NavMapper {

    public Nav selectLastNav(String fundCode);
}
