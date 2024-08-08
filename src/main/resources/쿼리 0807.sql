USE air;

SELECT 국가, COUNT(*) FROM 항공사 GROUP BY 국가;

SELECT * FROM 항공사 WHERE 국가 = 'USA' ORDER BY 도시코드;

SELECT COUNT(*) FROM 비행 WHERE 출발공한코드 = 'YAP';

SELECT 출발공한코드, COUNT(*) FROM 비행 GROUP BY 출발공한코드 ORDER BY 2;

SELECT a.년도, a.월, a.일, b.`이름` AS 요일,
		 a.실제출발시간, a.예정출발시간,
		 a.실제도착시간, a.예정도착시간,
		 a.항공편번호, a.비행거리
  FROM 비행 AS a
  INNER JOIN 요일 AS b
  ON a.`요일` = b.`코드`
  WHERE a.출발공항코드 = 'YAP';
  
CREATE VIEW 요일 as 
select 1 AS 코드,'월요일' AS 이름 
union select 2 AS 코드,'화요일' AS 이름 
union select 3 AS 코드,'수요일' AS 이름 
union select 4 AS 코드,'목요일' AS 이름 
union select 5 AS 코드,'금요일' AS 이름 
union select 6 AS 코드,'토요일' AS 이름 
union select 7 AS 코드,'일요일' AS 이름;

SELECT a.항공사명, a.도시, a.국가, b.설명
  FROM 항공사 AS a
 INNER JOIN 
 ( 
  SELECT a.출발공항코드, b.설명
    FROM 비행 AS a
   INNER JOIN 운반대 AS b
      ON a.항공사코드 = b.코드
   WHERE a.출발공항코드 = 'FOE' 
   GROUP BY a.출발공항코드, b.설명
 ) AS b
   ON a.항공사코드 = b.출발공항코드;
 /************************************************************************
 문제1) 비행 이력이 있는 도시의 목록을 출력하여 화면에 표현하고
 			하나의 도시를 선택 했을 경우에 도시의 정보와 비행 목록 데이터를
 			제공할수 있는 URL 주소를 만드시오.
**************************************************************************/

SELECT * FROM 항공사 AS a
WHERE EXISTS (SELECT 1 FROM 비행 
WHERE 비행취소여부 = 0
AND a.항공사코드 = 출발공항코드)

UNION
SELECT * FROM 항공사 AS a
WHERE EXISTS (SELECT 1 FROM 비행 
WHERE 비행취소여부 = 0
AND a.항공사코드 = 도착지공항코드)
;

SELECT 출발공항코드,항공사코드
	FROM 비행 AS a
	INNER JOIN 운반대 AS  b
	ON a.항공사코드 = b.`코드`
WHERE 출발공항코드 = 'ABE'
	GROUP BY 출발공항코드,항공사코드;


SELECT COUNT(출발공항코드) FROM 비행 
WHERE 비행취소여부 = 0;
