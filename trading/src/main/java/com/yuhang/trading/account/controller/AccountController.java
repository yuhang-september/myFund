package com.yuhang.trading.account.controller;

import com.yuhang.trading.account.service.AccountService;
import com.yuhang.trading.common.JsonResult;
import com.yuhang.trading.common.utils.SessionUtil;
import com.yuhang.trading.entity.account.Account;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @author David
 * @Date 2/29/2024 12:56 AM
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    AccountService accountService;

    @PostMapping("/find/{id}")
    public JsonResult findAccount(@PathVariable("id") String id) {
        HttpSession session = SessionUtil.getSession();
        Account account = (Account) session.getAttribute(id);
        if (account == null) {
            account = accountService.findById(id);
            if (account != null) {
                session.setAttribute(id, account);
            }
        }
        return new JsonResult(account);
    }

    @PostMapping("/modify")
    public JsonResult modifyAccount(@RequestBody Account account) {
        boolean result = accountService.modifyAccount(account);
        if (result) {
            SessionUtil.getSession().setAttribute(account.getId(), account);
        }
        return new JsonResult(result);
    }
}
