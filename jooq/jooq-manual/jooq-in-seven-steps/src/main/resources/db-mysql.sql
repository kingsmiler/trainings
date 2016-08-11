DROP DATABASE jooq;
CREATE DATABASE jooq
    COLLATE = 'utf8_general_ci'
    CHARACTER SET = 'utf8';
USE `jooq`;

CREATE TABLE `author` (
    `id`         INT NOT NULL,
    `first_name` VARCHAR(255) DEFAULT NULL,
    `last_name`  VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;