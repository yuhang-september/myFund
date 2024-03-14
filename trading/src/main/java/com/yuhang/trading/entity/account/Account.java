package com.yuhang.trading.entity.account;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1412989660382068256L;
    /**
     * customer's id
     * */
    private String id;
    /**
     * userName the full name, first name + last name
     * */
    private String name;
    /**
     * the password must be encoded by MD5.
     * */
    private String password;
    /**
     * certification number
     * */
    private String certificationNo;
    /**
     * certification type, if we want to look at the certification type, check the dictionary table
     * */
    private String certificationType;
    /**
     * customer's profession
     * */
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
