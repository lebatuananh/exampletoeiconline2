use toeiconline;

CREATE TABLE listtenguideline(
  listenguidelineid BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(512) NULL ,
  image VARCHAR(255) NULL ,
  contennt TEXT NULL ,
  createddate TIMESTAMP NULL ,
  modifieddate TIMESTAMP NULL
);
CREATE TABLE comment(
  commentid BIGINT NOT NULL  PRIMARY KEY  AUTO_INCREMENT,
  content TEXT NULL ,
  userid BIGINT NULL ,
  listenguidelineid BIGINT NULL ,
  createddate TIMESTAMP NULL
);