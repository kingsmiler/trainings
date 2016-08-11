DROP DATABASE jooq;
CREATE DATABASE jooq
  COLLATE = 'utf8_general_ci'
  CHARACTER SET = 'utf8';

USE `jooq`;

CREATE TABLE book (
  id    BIGINT PRIMARY KEY,
  title VARCHAR(255)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE author(
  id BIGINT PRIMARY KEY,
  name VARCHAR(255)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE book_author_rel (
  bookid   BIGINT NOT NULL,
  authorid BIGINT NOT NULL,
  FOREIGN KEY fk_book(bookid)
  REFERENCES book (id),
  FOREIGN KEY fk_author(authorid)
  REFERENCES author (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO book VALUES
  (1, 'Some book'),
  (2, 'Another Book'),
  (3, 'Some completely other book');

INSERT INTO author VALUES
  (1, 'tim'),
  (2, 'selena'),
  (3, 'thelma');

INSERT INTO book_author_rel VALUES
  (1, 1),
  (2, 2),
  (3, 2);