package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrierDTO {

	private String 항공사명;
	private String 도시;
	private String 국가;
	private String 설명;
}
