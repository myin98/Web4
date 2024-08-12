USE company;

CREATE TABLE user_role (
	userNo INT,
	releNo INT
);

INSERT INTO user_role VALUE (1, 2);
INSERT INTO user_role VALUE (2, 2);
INSERT INTO user_role VALUE (3, 2);
INSERT INTO user_role VALUE (4, 2);
INSERT INTO user_role VALUE (5, 2);
INSERT INTO user_role VALUE (6, 2);
INSERT INTO user_role VALUE (7, 2);
INSERT INTO user_role VALUE (8, 2);
INSERT INTO user_role VALUE (9, 2);
INSERT INTO user_role VALUE (10, 2);
INSERT INTO user_role VALUE (10, 1);

COMMIT;

SELECT userNo, userNm
FROM user 
WHERE userEnable = 1
AND userNm = '사용자10'
AND userPwd = 'pwd10';

SELECT r.roleNm
FROM user_role AS ur
INNER JOIN role AS r
ON ur.roleNo = r.roleNo
WHERE ur.userNo = 10