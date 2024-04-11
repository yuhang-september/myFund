package com.yuhang.trading.entity.payment;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AccountPaymentChannelRequest extends AccountPaymentChannel implements Serializable {


    @Serial
    private static final long serialVersionUID = 1369004285387906768L;
}
