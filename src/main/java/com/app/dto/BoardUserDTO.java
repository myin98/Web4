package com.app.dto;

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
	private String userRole;
}
