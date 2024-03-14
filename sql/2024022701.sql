CREATE TABLE `AC_ACCOUNT`
(
    `id`                 char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NOT NULL COMMENT 'user id',
    `name`               varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'full name: first name + last name',
    `certification_no`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT 'certification number',
    `certification_type` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      NOT NULL COMMENT 'certification types are in dictionary table',
    `profession`         char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      NOT NULL COMMENT 'professions are in dictionary table',
    `birthday`           date                                                          NOT NULL COMMENT 'birthday',
    `address_country`    char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      NULL DEFAULT NULL,
    `address_province`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
    `address_city`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
    `address_street`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `address_postcode`   varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
    `password`           char(49) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NOT NULL,
    `create_time`        datetime                                                      NOT NULL,
    `last_update_time`   datetime                                                      NOT NULL,
    `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `ac_account_idx2` (`certification_no` ASC, `certification_type` ASC) USING BTREE,
    INDEX `ac_account_idx1` (`name` ASC, `password` ASC) USING BTREE,
    INDEX `ac_account_idx3` (`birthday` ASC) USING BTREE,
    INDEX `ac_account_idx4` (`profession` ASC) USING BTREE,
    INDEX `ac_account_idx5` (`create_time` ASC) USING BTREE,
    INDEX `ac_account_idx6` (`last_update_time` ASC) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = 'The table tracks customers\' information.'
  ROW_FORMAT = Dynamic;

CREATE TABLE `AC_ACCOUNT_REQUEST`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `name`               varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'full name: first name + last name',
    `certification_no`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT 'certification number',
    `certification_type` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      NOT NULL COMMENT 'certification types are in dictionary table',
    `profession`         char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      NOT NULL COMMENT 'professions are in dictionary table',
    `birthday`           date                                                          NOT NULL COMMENT 'birthday',
    `address_country`    char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      NULL DEFAULT NULL,
    `address_province`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
    `address_city`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
    `address_street`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `address_postcode`   varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL,
    `password`           char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NOT NULL,
    `create_time`        datetime                                                      NOT NULL,
    `account_id` char(49) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `ac_account_request_idx1` (`account_id` ASC) USING BTREE,
    INDEX `ac_account_request_idx2` (`create_time` ASC) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = 'The table tracks accounts\' requests.'
  ROW_FORMAT = Dynamic;