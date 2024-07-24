package com.yuhang.service.entity.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author David
 * 2024-07-24 12:35 a.m.
 */
@Data
public class TradeBusiness implements Serializable {
    @Serial
    private static final long serialVersionUID = -6813680399770025485L;

    private String businessId;
    private String tradeRequestId;
    private String type;
    private String fundCode;
    private double amount;
    private double share;
    private int status;
    private Date createTime;
    private Date lastUpdateTime;
}
