CREATE TABLE ac_share
(
    `share_id`         char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `account_id`       char(49) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `fund_code`        char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `share`            decimal(10, 2)                                            NOT NULL,
    `payment_channel`  char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `create_time`      datetime                                                  NOT NULL,
    `last_update_time` datetime                                                  NOT NULL,
    PRIMARY KEY (`account_id`) USING BTREE,
    INDEX `ac_share_idx1` (`fund_code` ASC, `payment_channel` ASC) USING BTREE,
    INDEX `ac_share_idx2` (`create_time` ASC, `last_update_time` ASC) USING BTREE,
    INDEX `ac_share_idx3` (`account_id` ASC) USING BTREE
);