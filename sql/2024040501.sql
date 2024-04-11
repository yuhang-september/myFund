CREATE TABLE `ac_payment_channel`
(
    `id`              char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    NOT NULL,
    `account_no`      char(49) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    NOT NULL,
    `bank_account_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `payment_channel` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NOT NULL,
    `status` int NOT NULL COMMENT '0:active;1:frozen;2:inactive',
    `create_time` datetime NOT NULL,
    `last_update_time` datetime NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `ac_payment_channel_idx1` (`account_no` ASC) USING BTREE,
    INDEX `ac_payment_channel_idx2` (`bank_account_no` ASC) USING BTREE,
    INDEX `ac_payment_channel_idx3` (`payment_channel` ASC) USING BTREE
);

create table ac_payment_channel_request as select * from ac_payment_channel where 1=2;

CREATE TABLE `ru_payment_channel`
(
    `id`             int                                                       NOT NULL,
    `bank`           char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `payment_channel` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    PRIMARY KEY (`id` DESC) USING BTREE,
    INDEX `ru_payment_channel_idx1` (`bank` ASC) USING BTREE,
    INDEX `ru_payment_channel_idx2` (`payment_channel` ASC) USING BTREE
);