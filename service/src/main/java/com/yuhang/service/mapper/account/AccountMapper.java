package com.yuhang.service.mapper.account;

import com.yuhang.service.entity.account.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    public Account selectById(String id);

    Account selectByNameAndPassword(@Param("name") String name, @Param("password") String password);

    void insert(@Param("account") Account account);

    Account selectByCertification(@Param("certificationType") String certificationType, @Param("certificationNo") String certificationNo);

    boolean update(@Param("account") Account account);
}
