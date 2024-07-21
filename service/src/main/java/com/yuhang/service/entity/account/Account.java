package com.yuhang.service.entity.account;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1412989660382068256L;
    @NotNull
    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    private String password;

    @NotNull
    private String certificationNo;

    @NotNull
    private String certificationType;

    @NotNull
    private String profession;

    private Date birthday;

    private String phone;

    private String addressCountry;

    private String addressProvince;

    private String addressCity;

    private String addressStreet;

    private String addressPostcode;

    private Date createTime;

    private Date lastUpdateTime;
}
