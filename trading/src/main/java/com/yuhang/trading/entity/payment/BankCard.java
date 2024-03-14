package com.yuhang.trading.entity.payment;

import lombok.Data;

/**
 * Description:
 *
 * @author David
 * @Date 2/29/2024 9:18 PM
 */
@Data
public class BankCard {

    private String bankAccountNo;

    private String bank;

    private String phone;

    private String name;
}
