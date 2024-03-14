CREATE TABLE `sys_dictionary`
(
    `id`   char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    NOT NULL,
    `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `sys_dictionary_idx1` (`name` ASC) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = 'Dictionary table'
  ROW_FORMAT = Dynamic;

CREATE TABLE `sys_dictionary_item`
(
    `id`            char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    NOT NULL,
    `name`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `dictionary_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    NOT NULL,
    `value`         char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci    NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `dictionary_id` (`dictionary_id` ASC) USING BTREE,
    CONSTRAINT `sys_dictionary_item_fk1` FOREIGN KEY (`dictionary_id`) REFERENCES `sys_dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = 'Dictionary item table.'
  ROW_FORMAT = Dynamic;