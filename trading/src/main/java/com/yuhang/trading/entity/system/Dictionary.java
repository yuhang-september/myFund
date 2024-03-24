package com.yuhang.trading.entity.system;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * Description:
 *
 * @author David
 * @Date 2/28/2024 1:50 AM
 */
@Data
public class Dictionary implements Serializable {

    @Serial
    private static final long serialVersionUID = 1065875494659057511L;
    private String id;

    private String name;
}
