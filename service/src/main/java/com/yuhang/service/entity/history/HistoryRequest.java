package com.yuhang.service.entity.history;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author David
 * 2024-06-13 12:42 a.m.
 */
@Data
public class HistoryRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -1219131617691164944L;

    private String tradeRequestId;

    private String fundType;

    private String fundCode;

    private String tradeType;

    private Date startDate;

    private Date endDate;

    private String tradeAccountId;
}
