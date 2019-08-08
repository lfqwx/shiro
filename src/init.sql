-- 权限表 --
CREATE TABLE permission(
pid int(11) NOT NULL PRIMARY KEY auto_increment,
name varchar(255) not null DEFAULT '',
url varchar(255) default ''
);
INSERT INTO permission VALUES (1,'add','');
INSERT INTO permission VALUES (2,'update','');
INSERT INTO permission VALUES (3,'delete','');
INSERT INTO permission VALUES (4,'query','');

-- 用户表 --
CREATE TABLE user(
uid int(11) NOT NULL PRIMARY KEY auto_increment,
username VARCHAR(255) NOT NULL DEFAULT '',
password VARCHAR(255) NOT NULL DEFAULT ''
);
INSERT INTO user VALUES (1,'admin','123');
INSERT INTO user VALUES (2,'wx','wx');
INSERT INTO user VALUES (3,'cy','cy');
-- 角色表 --
CREATE TABLE role(
rid int(11) NOT NULL PRIMARY KEY auto_increment,
rname VARCHAR(255) NOT NULL DEFAULT ''
);

INSERT INTO role VALUES (1,'admin');
INSERT INTO role VALUES(2,'customer');
-- 权限角色关系表 --
CREATE TABLE permission_role(
rid int(11) NOT NULL ,
pid int(11) NOT NULL ,
KEY idx_rid(rid),
KEY idx_pid(pid)
);
INSERT INTO permission_role VALUES (1,1);
INSERT INTO permission_role VALUES (1,2);
INSERT INTO permission_role VALUES (1,3);
INSERT INTO permission_role VALUES (1,4);
INSERT INTO permission_role VALUES (2,1);
INSERT INTO permission_role VALUES (2,4);
-- 用户角色表 --
CREATE TABLE user_role(
uid int(11) NOT NULL ,
rid int(11) NOT NULL ,
KEY idx_uid(uid),
KEY idx_rid(rid)
);
INSERT INTO user_role VALUES (1,1);
INSERT INTO user_role VALUES (2,2);