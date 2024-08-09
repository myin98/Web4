package com.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.app.dto.BoardUserDTO;

@Mapper
public interface CompanyUserMapper {

	@Select("select userNo, userNm, userRole from company.`user` where userEnable = 1 and userNm = #{userNm} and userPwd = #{userPwd}")
	public BoardUserDTO findByUser(BoardUserDTO userDTO);
}

