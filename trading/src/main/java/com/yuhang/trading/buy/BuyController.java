package com.yuhang.trading.buy;

import com.yuhang.service.entity.request.TradeRequest;
import com.yuhang.service.common.JsonResult;
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
@RequestMapping("/buy")
public class BuyController {

    @Resource
    BuyService buyService;

    @PostMapping("")
    public JsonResult<Object> buy(@RequestBody TradeRequest request) {
        buyService.buy(request);
        return new JsonResult<>(null);
    }
}
