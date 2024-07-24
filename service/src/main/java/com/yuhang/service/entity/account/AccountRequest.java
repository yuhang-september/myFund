package com.yuhang.service.entity.account;

import lombok.Data;

import java.io.Serial;

/**
 * Description:
 * The class is to record the account request of modification.
 * @author David
 * 2/29/2024 12:39 AM
 */
@Data
public class AccountRequest extends Account {

    @Serial
    private static final long serialVersionUID = -6312116802199891771L;
    private String accountId = super.getId();
}
