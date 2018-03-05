use toeiconline;
ALTER TABLE comment ADD CONSTRAINT fk_user_comment FOREIGN KEY (userid) REFERENCES user(userid);
ALTER TABLE comment ADD CONSTRAINT fk_listtenguideline_comment FOREIGN KEY (listenguidelineid) REFERENCES listtenguideline(listenguidelineid);