package com.yuhang.trading.payment;

import com.yuhang.trading.common.Constants;
import com.yuhang.trading.common.JsonResult;
import com.yuhang.trading.common.RedisService;
import com.yuhang.trading.common.RuleException;
import com.yuhang.trading.common.utils.SessionUtil;
import com.yuhang.trading.entity.account.Account;
import com.yuhang.trading.entity.payment.BankCard;
import com.yuhang.trading.payment.service.PaymentChannelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author David
 * 2/29/2024 9:04 PM
 */
@Tag(name="Payment Channel Controller", description = "The controller is to add bank cards and query the relative information.")
@RestController
@RequestMapping("/payment")
public class PaymentChannelController {

    @Resource
    RedisService redisService;

    @Resource
    PaymentChannelService paymentChannelService;

    /**
     * Adding a bank card in a fund trading system is complicated, we deal with it simply.
     * Just adding a payment to an account, don't need to use the interfaces of banks and any authorizations.
     */
    @PostMapping("/addCard")
    public JsonResult addCard(@RequestBody BankCard bankCard) throws RuleException {
        validate(bankCard);
        return new JsonResult(savePaymentChannel(bankCard));
    }

    @PostMapping("queryAll")
    public JsonResult queryAll() {
        Account accountInfo = SessionUtil.getAccountInfo();
        String accountId = accountInfo.getId();
        return new JsonResult(paymentChannelService.queryAllAccountPaymentChannels(accountId));
    }

    private boolean savePaymentChannel(BankCard bankCard) throws RuleException {
        return paymentChannelService.savePaymentChannel(bankCard);
    }

    private void validate(BankCard bankCard) throws RuleException {
        String message = null;
        if (StringUtils.isBlank(bankCard.getBankAccountNo())) {
            message = "Please input the bank account number.";
        } else if (StringUtils.isBlank(bankCard.getName()) || differentName(bankCard.getName())) {
            message = "Please check your name, it can't be empty or the different with your real full name.";
        } else if (StringUtils.isBlank(bankCard.getBank()) || !redisService.existRedisDictionaryItemValue(Constants.BANK, bankCard.getBank())) {
            message = "Please input the correct bank.";
        } else if (StringUtils.isBlank(bankCard.getPhone())) {
            message = "Please input your phone number.";
        }

        //we simplify the process, don't need to invoke the bank interface to verify information.
        if (StringUtils.isNotBlank(message)) {
            throw new RuleException(JsonResult.ACCOUNT_ERROR, message);
        }
    }

    private boolean differentName(String name) {
        Account account = SessionUtil.getAccountInfo();
        return !StringUtils.equals(name, account.getName());
    }
}
