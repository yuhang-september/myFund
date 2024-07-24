CREATE TABLE pd_nav
(
    `id`        char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `fund_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `date`      datetime                                                  NOT NULL,
    `nav`       decimal(10, 2)                                            NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `pd_nav_idx1` (`fund_code` ASC) USING BTREE,
    INDEX `pd_nav_idx2` (`date` ASC) USING BTREE
);

CREATE TABLE tr_trade_business
(
    `trade_business_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `trade_request_id`  char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `fund_code`         char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `amount`            decimal(10, 2)                                            NULL DEFAULT NULL,
    `share`             decimal(10, 2)                                            NOT NULL,
    `create_date`       datetime                                                  NOT NULL,
    `last_update_date`  datetime                                                  NOT NULL,
    `status`            int                                                       NOT NULL,
    `type`              char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    PRIMARY KEY (`trade_business_id` DESC) USING BTREE,
    INDEX `trade_business_idx1` (`trade_request_id` ASC) USING BTREE,
    INDEX `trade_business_idx2` (`fund_code` ASC) USING BTREE,
    INDEX `trade_business_idx3` (`type` ASC) USING BTREE,
    INDEX `trade_business_idx4` (`create_date` ASC) USING BTREE
);