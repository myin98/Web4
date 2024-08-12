package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardTableDTO {

	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String userNm;
	
	
}
