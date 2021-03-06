CREATE DATABASE IF NOT EXISTS `spring`
  DEFAULT CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON spring.* TO 'spring'@'%'
IDENTIFIED BY 'spring';

USE spring;

DROP TABLE IF EXISTS `village`;
CREATE TABLE `village` (
  `name`     VARCHAR(50) NULL DEFAULT NULL,
  `district` VARCHAR(50) NULL DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;