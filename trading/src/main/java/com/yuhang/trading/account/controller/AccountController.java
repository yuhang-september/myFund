package com.yuhang.trading.account.controller;

import com.yuhang.service.entity.account.Account;
import com.yuhang.trading.account.service.AccountService;
import com.yuhang.trading.common.JsonResult;
import com.yuhang.trading.common.utils.SessionUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

/**
 * @author David
 * 2/29/2024 12:56 AM
 */
@Tag(name = "Account Controller", description = "The controller is to operate the information of an account.")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    AccountService accountService;

    @PostMapping("/find/{id}")
    public JsonResult<Account> findAccount(@PathVariable("id") String id) {
        HttpSession session = SessionUtil.getSession();
        Account account = (Account) session.getAttribute(id);
        if (account == null) {
            account = accountService.findById(id);
            if (account != null) {
                session.setAttribute(id, account);
            }
        }
        return new JsonResult<>(account);
    }

    @PostMapping("/modify")
    public JsonResult<Boolean> modifyAccount(@RequestBody Account account) {
        boolean result = accountService.modifyAccount(account);
        if (result) {
            SessionUtil.getSession().setAttribute(account.getId(), account);
        }
        return new JsonResult<>(result);
    }
}
