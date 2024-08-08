package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirDTO {

	private int 년도;
	private int 월;
	private int 일;
	private String 요일;
	private String 실제출발시간;
	private int 예정출발시간;
	private String 실제도착시간;
	private int 예정도착시간;
	private int 항공편번호;
	private String 비행거리;
	
}
