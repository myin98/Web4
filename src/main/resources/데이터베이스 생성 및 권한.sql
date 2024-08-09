-- root 사용자로 접속 후 실행
USE mysql;

CREATE DATABASE company;

GRANT ALL ON company.* TO 'user'@'%';

FLUSH PRIVILEGES;

SHOW GRANTS FOR 'user'@'%';

-- test 사용자로 접속 후 실행
USE company;

CREATE TABLE `user` (
	userNo 			INT 				NOT NULL AUTO_INCREMENT PRIMARY KEY,
	userNm 			VARCHAR(50) 	NOT NULL,
	userPwd			VARCHAR(50)		NOT NULL,
	userEnable		BOOLEAN			NOT NULL DEFAULT 1,
	userRole			VARCHAR(10)		NOT NULL DEFAULT 'USER'
);

CREATE TABLE `notice` (
	noticeNo			INT				NOT NULL AUTO_INCREMENT PRIMARY KEY,
	noticeTitle		VARCHAR(50)		NOT NULL,
	noticeContent	VARCHAR(255)	NULL,
	userNo			INT 				NOT NULL
);

CREATE TABLE `role` (
	roleNo		INT				NOT NULL AUTO_INCREMENT PRIMARY KEY,
	roleNm		VARCHAR(50) 	NOT NULL
);

