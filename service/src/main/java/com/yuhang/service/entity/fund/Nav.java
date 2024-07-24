package com.yuhang.service.entity.fund;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author David
 * 2024-07-24 12:49 a.m.
 */
@Data
public class Nav implements Serializable {
    @Serial
    private static final long serialVersionUID = 1004726146079870280L;

    private String id;
    private String fundCode;
    private Date date;
    private double nav;
}
