package com.yuhang.service.entity.account;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author David
 * 2024-07-24 1:50 a.m.
 */
@Data
public class AccountShare implements Serializable {
    @Serial
    private static final long serialVersionUID = -385321867338451958L;

    private String shareId;
    private String accountId;
    private String fundCode;
    private double share;
    private String paymentChannel;
    private Date createTime;
    private Date lastUpdateTime;
}
