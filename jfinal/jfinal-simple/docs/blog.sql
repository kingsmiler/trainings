CREATE DATABASE `jfinal`
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE USER 'jfinal'@'%'
  IDENTIFIED BY 'jfinal';

GRANT ALL PRIVILEGES ON jfinal.* TO 'jfinal'@'%';

USE jfinal;

CREATE TABLE `blog` (
  `id`      INT(11)      NOT NULL AUTO_INCREMENT,
  `title`   VARCHAR(200) NOT NULL,
  `content` MEDIUMTEXT   NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO `blog` VALUES ('1', 'JFinal Demo Title here', 'JFinal Demo Content here');
INSERT INTO `blog` VALUES ('2', 'test 1', 'test 1');
INSERT INTO `blog` VALUES ('3', 'test 2', 'test 2');
INSERT INTO `blog` VALUES ('4', 'test 3', 'test 3');
INSERT INTO `blog` VALUES ('5', 'test 4', 'test 4');