package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AirCarrierFlyDTO;
import com.app.dto.AirDTO;
import com.app.dto.AirDetailDTO;
import com.app.dto.AirFDTO;
import com.app.dto.AirResultDTO;
import com.app.dto.AirTimeDTO;
import com.app.dto.AirWeekDTO;
import com.app.dto.CarrierDTO;
import com.app.mapper.AirMapper;

@Service
public class AirService {

	@Autowired
	private AirMapper airMapper;
	
	public List<AirResultDTO> findAll(String code){
		List<AirDTO> airs = airMapper.findAll(code);
		List<AirResultDTO> resultList = new ArrayList<>();
		for(AirDTO air : airs) {
			resultList.add(AirResultDTO.builder()
					.날짜(air.get년도() + "-" + air.get월() + "-" +air.get일())
					.요일(air.get요일())
					.실제출발시간(air.get실제출발시간())
					.예정출발시간(""+air.get예정출발시간())
					.실제도착시간(air.get실제도착시간())
					.예정도착시간(""+air.get예정도착시간())
					.항공편번호(""+air.get항공편번호())
					.비행거리(air.get비행거리())
					.build());
		}
		
		
		return resultList; //airMapper.findAll();
	}
	
	public AirDetailDTO findOne(String code) {
		CarrierDTO carrier = airMapper.findOne(code);
		List<AirResultDTO> airResult = findAll(code);
		return AirDetailDTO.builder()
				.carrier(carrier)
				.airResult(airResult)
				.build();
		
		
		//return //airMapper.findOne(code);
	}
	
	public List<AirFDTO> airf(){
		
		return airMapper.airF();
	}
	
	public List<AirWeekDTO> findByWeek(int n){
		return airMapper.findByWeek(n);
	}
	
	public List<AirTimeDTO> findByTime(){
		return airMapper.findByTime();
	}
	
	public List<AirCarrierFlyDTO> findByCarrier(){
		return airMapper.findByCarrier();
	}
	
	
}
