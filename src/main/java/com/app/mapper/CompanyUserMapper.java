package com.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.app.dto.BoardUserDTO;
import com.app.dto.RoleDTO;

@Mapper
public interface CompanyUserMapper {

	@Select("select userNo, userNm from company.`user` where userEnable = 1 and userNm = #{userNm} and userPwd = #{userPwd}")
	public BoardUserDTO findByUser(BoardUserDTO userDTO);
	
	@Select("SELECT r.roleNm "
			+ "FROM user_role AS ur "
			+ "INNER JOIN role AS r "
			+ "ON ur.roleNo = r.roleNo "
			+ "WHERE ur.userNo = #{userNo}")
	public List<RoleDTO> findByRoles(int userNo);
}

