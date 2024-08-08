package com.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.app.dto.AirCarrierFlyDTO;
import com.app.dto.AirDTO;
import com.app.dto.AirFDTO;
import com.app.dto.AirTimeDTO;
import com.app.dto.AirWeekDTO;
import com.app.dto.CarrierDTO;

@Mapper
public interface AirMapper {

	@Select("SELECT a.년도, a.월, a.일, b.`이름` AS 요일,"
			+ "		a.실제출발시간, a.예정출발시간,"
			+ "		a.실제도착시간, a.예정도착시간,"
			+ "		a.항공편번호, a.비행거리"
			+ "  FROM 비행 AS a"
			+ "  INNER JOIN 요일 AS b"
			+ "  ON a.`요일` = b.`코드`"
			+ "  WHERE a.출발공항코드 = #{code}")
	public List<AirDTO> findAll(String code);
	
	@Select("SELECT a.항공사명, a.도시, a.국가, b.설명"
			+ "  FROM 항공사 AS a"
			+ " INNER JOIN "
			+ " ( "
			+ "  SELECT a.출발공항코드, b.설명"
			+ "    FROM 비행 AS a"
			+ "   INNER JOIN 운반대 AS b"
			+ "      ON a.항공사코드 = b.코드"
			+ "   WHERE a.출발공항코드 = #{code} "
			+ "   GROUP BY a.출발공항코드, b.설명"
			+ " ) AS b"
			+ "   ON a.항공사코드 = b.출발공항코드")
	public CarrierDTO findOne(String code);
	
	@Select("SELECT 도시 FROM 항공사")
	public List<AirFDTO> airF();
	
	
	@Select("SELECT WEEK(CONCAT(CAST(년도 AS CHAR), '-',CAST(월 AS CHAR), '-',CAST(일 AS CHAR))) AS 주, COUNT(*) AS 비행횟수 "
			+ "	FROM 비행 "
			+ "WHERE 월 = #{n} "
			+ "GROUP BY WEEK(CONCAT(CAST(년도 AS CHAR), '-',CAST(월 AS CHAR), '-',CAST(일 AS CHAR)))")
	public List<AirWeekDTO> findByWeek(int n);
	
	@Select("SELECT '종합', COUNT(*) AS 비행횟수 FROM 비행 "
			+ "UNION "
			+ "SELECT * FROM											"
			+ "("
			+ "	SELECT '오전', COUNT(*) FROM 비행 WHERE 예정출발시간 < 1200"
			+ "	UNION"
			+ "	SELECT '오후', COUNT(*) FROM 비행 WHERE 예정출발시간 >= 1200"
			+ ") AS a ORDER BY 2 DESC")
	public List<AirTimeDTO> findByTime();
	
	@Select("SELECT 코드, COUNT(*) AS 비행횟수 FROM 운반대 GROUP BY 코드 "
			+ "UNION "
			+ "SELECT 항공사코드, COUNT(*) FROM 비행 WHERE 비행취소여부 = 0 GROUP BY 항공사코드 "
			+ "ORDER BY 2 DESC LIMIT 10")
	public List<AirCarrierFlyDTO> findByCarrier();
	
	
}
