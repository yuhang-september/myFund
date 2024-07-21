package com.yuhang.trading.common.utils;

import com.yuhang.service.entity.account.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Description:
 *
 * @author David
 * @Date 2/29/2024 12:15 AM
 */
public class SessionUtil {

    public static HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    public static Account getAccountInfo(){
        HttpSession session = getSession();
        return (Account) session.getAttribute("account");
    }
}
