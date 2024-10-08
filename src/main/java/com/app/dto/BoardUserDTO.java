package com.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardUserDTO {

	private int userNo;
	private String userNm;
	private String userPwd;
	private List<RoleDTO> userRoles;
}
