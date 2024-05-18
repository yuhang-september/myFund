package com.yuhang.trading.history;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David
 * 5/17/2024
 */
@Tag(name="History Controller", description = "The controller is to query the trading history.")
@RestController
@RequestMapping("/history")
public class HistoryController {


}
