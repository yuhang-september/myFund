package com.yuhang.trading.entity.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class TradeRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -8285979657092079090L;

    @Id
    private String tradeRequestId;

    @NotEmpty
    @Length(max = 6)
    private String fundCode;

    @Min(0)
    private double applicationAmount;

    private int status;

    private String confirmStatus;

    private double confirmAmount;

    private double confirmShare;

    private Date createTime;

    private Date lastUpdateTime;

    @NotEmpty
    private String type;
}
