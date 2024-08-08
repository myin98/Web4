package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirResultDTO {

	private String 날짜;
	private String 요일;
	private String 실제출발시간;
	private String 예정출발시간;
	private String 실제도착시간;
	private String 예정도착시간;
	private String 항공편번호;
	private String 비행거리;
}
