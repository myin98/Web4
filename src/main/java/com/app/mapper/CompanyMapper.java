package com.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.app.dto.BoardTableDTO;

@Mapper
public interface CompanyMapper {

	@Select("select a.noticeNo , a.noticeTitle , a.noticeContent , "
			+ "			b.userNm, b.userRole "
			+ "			from company.notice AS a "
			+ "left join company.`user` AS b on a.userNo = b.userNo ORDER BY a.noticeNo DESC; ")
	public List<BoardTableDTO> BoardTable(BoardTableDTO boardTableDTO);

	@Select(" select userNo from notice where noticeNo = #{noticeNo}")
	public int check(int noticeNo);
	
}
