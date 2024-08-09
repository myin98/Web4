USE company;

insert into user values (1,'사용자1','pwd1',1,'USER');
insert into user values (2,'사용자2','pwd2',1,'USER');
insert into user values (3,'사용자3','pwd3',1,'USER');
insert into user values (4,'사용자4','pwd4',1,'USER');
insert into user values (5,'사용자5','pwd5',1,'USER');
insert into user values (6,'사용자6','pwd6',1,'USER');
insert into user values (7,'사용자7','pwd7',1,'USER');
insert into user values (8,'사용자8','pwd8',1,'USER');
insert into user values (9,'사용자9','pwd9',1,'USER');
insert into user values (10,'사용자10','pwd10',1,'USER');
insert into user values (11,'사용자11','pwd11',1,'USER');
insert into user values (12,'사용자12','pwd12',1,'USER');
insert into user values (13,'사용자13','pwd13',1,'USER');
insert into user values (14,'사용자14','pwd14',1,'USER');
insert into user values (15,'사용자15','pwd15',1,'USER');
insert into user values (16,'사용자16','pwd16',1,'USER');
insert into user values (17,'사용자17','pwd17',1,'USER');
insert into user values (18,'사용자18','pwd18',1,'USER');
insert into user values (19,'사용자19','pwd19',1,'USER');
insert into user values (20,'사용자20','pwd20',1,'USER');


insert into notice values (1,'글제목1','내용 테스트',1);
insert into notice values (2,'글제목2','글 넣어 보기',2);
insert into notice values (3,'글제목3','하나 부터 열까지!!',4);
insert into notice values (4,'글제목4','자유게시판 가즈아',5);
insert into notice values (5,'글제목5','테스트 중입니다.',6);
insert into notice values (6,'글제목6','글 작성 잘 됩니다.',9);
insert into notice values (7,'글제목7','연습용1',11);
insert into notice values (8,'글제목8','연습용2',11);
insert into notice values (9,'글제목9','누군지 알아보세요',14);
insert into notice values (10,'글제목10','아무도 모르겠지?',16);


COMMIT;

SELECT COUNT(*) FROM user;
SELECT COUNT(*) FROM notice;
