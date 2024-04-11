package com.yuhang.trading.account.service;

import com.yuhang.trading.common.utils.DateUtil;
import com.yuhang.trading.entity.account.Account;
import com.yuhang.trading.entity.account.AccountRequest;
import com.yuhang.trading.mapper.account.AccountMapper;
import com.yuhang.trading.mapper.account.AccountRequestMapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Description:
 * The service is used to handle account relevant transactions.
 *
 * @author David
 * @Date 2/27/2024 2:29 AM
 */
@Service
public class AccountService {

    @Resource
    AccountMapper accountMapper;

    @Resource
    AccountRequestMapper accountRequestMapper;

    /**
     * The method to generate an account ID, the structure is the timestamp + uuid, the length is 49.
     * @return String account ID
     * */
    public String generateAccountId() {
        return DateUtil.getFormattedDate("yyyyMMddHHmmssSSS") + UUID.randomUUID().toString().replaceAll("-", "");
    }

    public Account findByNameAndPassword(String name, String password) {
        return accountMapper.selectByNameAndPassword(name, password);
    }

    /**
     * When insert an account data, we should save both account request and account data.
     * The account request is used to record the creation and modification.
     * If we have a background system, we can search for a customer's account information including the creation and each modification.
     * @param account the information of an account
     * */
    @Transactional()
    public void saveAccount(Account account) {
        if (StringUtils.isBlank(account.getId())) {
            account.setId(generateAccountId());
        }
        Date currentDate = DateUtil.getCurrentDate();
        account.setCreateTime(currentDate);
        account.setLastUpdateTime(currentDate);
        accountRequestMapper.insert(getCopiedAccountRequest(account));
        accountMapper.insert(account);
    }

    public Account findByCertification(String certificationType, String certificationNo) {
        return accountMapper.selectByCertification(certificationType, certificationNo);
    }

    public Account findById(String id) {
        return accountMapper.selectById(id);
    }

    @Transactional
    public boolean modifyAccount(Account account) {
        account.setLastUpdateTime(DateUtil.getCurrentDate());
        accountRequestMapper.insert(getCopiedAccountRequest(account));
        return accountMapper.update(account);
    }

    private AccountRequest getCopiedAccountRequest(Account account) {
        AccountRequest accountRequest = new AccountRequest();
        BeanUtils.copyProperties(account, accountRequest);
        accountRequest.setAccountId(account.getId());
        accountRequest.setCreateTime(DateUtil.getCurrentDate());
        return accountRequest;
    }
}
