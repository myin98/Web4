package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class HomeController {

	@ResponseBody
	@GetMapping("/test")
	public Map<String, Object> test() {
		Map<String, Object> map = new HashMap<>();
		map.put("no", 1);
		map.put("nm", "테스트");
		return map;
	}
	
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@ResponseBody
	@PostMapping("/logins")
	public Map<String, Object> login(HttpServletRequest req){
		Map<String, Object> rm = new HashMap<>();
		rm.put("status", true);
		rm.put("msg", "로그인 성공");
		HttpSession session = req.getSession();
		session.setAttribute("name", "대재학");		
		return rm;
	}
	
	@ResponseBody
	@PostMapping("/infos")
	public Map<String, Object> info(HttpServletRequest req){
		Map<String, Object> rm = new HashMap<>();
		
		HttpSession session = req.getSession();
		Object name = session.getAttribute("name");
		rm.put("name", name);
		
		return rm;
	}
	
	@ResponseBody
	@PostMapping("/logouts")
	public Map<String, Object> logout(HttpServletRequest req){
		Map<String, Object> rm = new HashMap<>();
		HttpSession session = req.getSession();
		session.removeAttribute("name");
		rm.put("status", true);
		rm.put("msg", "로그아웃");
		
		return rm;
	}
	
	
	
	
}
