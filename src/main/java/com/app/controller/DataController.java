package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AirCarrierFlyDTO;
import com.app.dto.AirDTO;
import com.app.dto.AirDetailDTO;
import com.app.dto.AirFDTO;
import com.app.dto.AirResultDTO;
import com.app.dto.AirTimeDTO;
import com.app.dto.AirWeekDTO;
import com.app.dto.CarrierDTO;
import com.app.service.AirService;

@RestController
@RequestMapping("/data")
public class DataController {

	@GetMapping("")
	public String home() {
		return "Data ON!";
	}
	@Autowired
	private AirService airService;
	
//	@GetMapping("/findAll")
//	public List<AirResultDTO> findAll(){
//		
//		return airService.findAll();
//	}
	
	@GetMapping("/findOne")
	public AirDetailDTO findOne(@RequestParam("code") String code) {

		return airService.findOne(code);
	}
	
	@GetMapping("/airf")
	public List<AirFDTO> airf() {
		return airService.airf();
	}
	
	@GetMapping("/findByWeek")
	public List<AirWeekDTO> findByWeek(@RequestParam("n") int n){
		return airService.findByWeek(n);
	}
	
	@GetMapping("/findByTime")
	public List<AirTimeDTO> findByTime(){
		return airService.findByTime();
	}
	@GetMapping("findByCarrier")
	public List<AirCarrierFlyDTO> findByCarrier(){
		return airService.findByCarrier();
	}
}
