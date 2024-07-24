package com.yuhang.service.entity.fund;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author David
 * 2024-07-24 12:47 a.m.
 */
@Data
public class Fund implements Serializable {
    @Serial
    private static final long serialVersionUID = 6668916084018149111L;

    private String fundCode;
    private String name;
    private String type;
    private Date publishDate;
    private String manager;
    private String company;
}
