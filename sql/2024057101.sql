CREATE TABLE `tr_trade_request`
(
    `tr_trade_request_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `fund_code`           char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `application_amount`  decimal(10, 2)                                            NOT NULL,
    `status`              int                                                       NOT NULL,
    `confirm_status`      int                                                       NULL DEFAULT NULL,
    `confirm_share`       decimal(10, 2)                                            NULL DEFAULT NULL,
    `confirm_amount`      decimal(10, 2)                                            NULL DEFAULT NULL,
    `create_time`         datetime                                                  NOT NULL,
    `last_update_time`    datetime                                                  NOT NULL,
    `type` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    'trade_account_id'    char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    PRIMARY KEY (`tr_trade_request_id`) USING BTREE,
    INDEX `trade_request_idx1` (`tr_trade_request_id` ASC) USING BTREE,
    INDEX `trade_request_idx2` (`fund_code` ASC) USING BTREE,
    INDEX `trade_request_idx3` (`status` ASC) USING BTREE,
    INDEX `trade_request_idx4` (`create_time` ASC, `last_update_time` ASC) USING BTREE,
    INDEX `trade_request_idx5` (`trade_account_id` ASC) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = 'The trading requests including buying, redeem,and convert.'
  ROW_FORMAT = Dynamic;