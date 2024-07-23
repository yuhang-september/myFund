package com.yuhang.trading.redeem;

import com.yuhang.service.entity.request.TradeRequest;
import com.yuhang.trading.common.JsonResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David
 * 2024-05-17 8:48 p.m.
 */
@Tag(name = "Purchase Controller", description = "This controller is used to process subscription transactions.")
@RestController
@RequestMapping("/redeem")
public class RedeemController {

    @Resource
    RedeemService RedeemService;

    @PostMapping("")
    public JsonResult<Object> redeem(@RequestBody TradeRequest request) {
        RedeemService.redeem(request);
        return new JsonResult<>(null);
    }
}
