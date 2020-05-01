--CREATE TABLE IF NOT EXISTS chess (
--  room_id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
--  title varchar(45) NOT NULL,
--  board varchar(64) NOT NULL,
--  is_white tinyint(1) NOT NULL
--) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS chess (
  room_id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title varchar(45) NOT NULL,
  board varchar(64) NOT NULL,
  is_white tinyint(1) NOT NULL
);