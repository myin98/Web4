USE air;

SELECT 요일, COUNT(*) FROM 비행 WHERE 월 = 10 GROUP BY 요일 ORDER BY 2 DESC;

SELECT 월, COUNT(*) FROM 비행 WHERE 년도 = 1987 GROUP BY 월 ORDER BY 2 DESC;

-- 3개월의 비행 이력중 가장 많이 비행 이력이 있는 월과 요일을 구하시오.  10월 , 목요일
-- 단 한달의 기준의 가장 높은 요일 한건씩 조회 하세요.

SELECT 월,요일, COUNT(*) FROM 비행 GROUP BY 월,요일 ORDER BY 3 DESC;

SELECT 월,요일, COUNT(*) FROM 비행 WHERE 월 = 10 GROUP BY 월,요일 ORDER BY 3 DESC LIMIT 1;

SELECT 월,요일, COUNT(*) FROM 비행 WHERE 월 = 11 GROUP BY 월,요일 ORDER BY 3 DESC LIMIT 1;

SELECT 월,요일, COUNT(*) FROM 비행 WHERE 월 = 12 GROUP BY 월,요일 ORDER BY 3 DESC LIMIT 1;

-- 비행 이력 중에 예정출발시간 대가 가장 많은 시간대가 오전 또는 오후 중 어느것인지 찾으시오.
	--서브 쿼리로 오전,오후중 높은순으로 정렬 (단 서브쿼리는 데이터가 많을시 성능저하를 일으킴)
SELECT '종합', COUNT(*) FROM 비행
UNION 
SELECT * FROM											
(
	SELECT '오전', COUNT(*) FROM 비행 WHERE 예정출발시간 < 1200
	UNION
	SELECT '오후', COUNT(*) FROM 비행 WHERE 예정출발시간 >= 1200
) AS a ORDER BY 2 DESC
;

-- 항공 이력이 있는 운반대 중 가장 비행 이력이 높은 운반대 10개를 조회 하시오

SELECT 항공사코드, COUNT(*) FROM 비행 GROUP BY 항공사코드;
SELECT COUNT(*) FROM 운반대;

SELECT 항공사코드, COUNT(*) FROM 비행 GROUP BY 항공사코드;

-- 내가 만든 쿼리
SELECT 코드, COUNT(*) FROM 운반대 GROUP BY 코드
UNION
SELECT 항공사코드, COUNT(*) FROM 비행 WHERE 비행취소여부 = 0 GROUP BY 항공사코드
ORDER BY 2 DESC LIMIT 10;

-- 강사님 쿼리
SELECT b.`설명`, COUNT(*) AS 운행수
	FROM 비행 AS a
	INNER JOIN 운반대 AS b
	ON a.`항공사코드` = b.`코드`
	WHERE a.`비행취소여부` = 0
	GROUP BY b.`설명`
ORDER BY 2 DESC LIMIT 10;

-- 10월 기준으로 각 주마다 비행 이력을 조회 하시오.
SELECT 일, 요일, COUNT(*) FROM 비행 WHERE 월= 10 GROUP BY 일, 요일;

SELECT 출발공항코드,도착지공항코드, COUNT(*) FROM 비행 WHERE 비행취소여부 = 0 GROUP BY 출발공항코드,도착지공항코드 ORDER BY 3 DESC;


SELECT '주', COUNT(*) FROM 비행 WHERE 월 = 10 AND 일 < 8 AND 비행취소여부 = 0

SELECT '주', COUNT(*) FROM 비행 WHERE 일 < 8

SELECT WEEK('1987-10-01'), CAST(1987 AS CHAR), CAST(10 AS CHAR), CAST(1 AS CHAR),
		CONCAT(CAST(1987 AS CHAR), '-', CAST(10 AS CHAR), '-' , CAST(1 AS CHAR)),
		WEEK(CONCAT(CAST(1987 AS CHAR), '-', CAST(10 AS CHAR), '-',CAST(1 AS CHAR)))
;

SELECT WEEK(CONCAT(CAST(년도 AS CHAR), '-',CAST(월 AS CHAR), '-',CAST(일 AS CHAR))) AS 주, COUNT(*) 
	FROM 비행
WHERE 월 = 10
GROUP BY WEEK(CONCAT(CAST(년도 AS CHAR), '-',CAST(월 AS CHAR), '-',CAST(일 AS CHAR)))
;