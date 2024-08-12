package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

		@ResponseBody
		@GetMapping("/getCookie")
		public Cookie[] getCookie(HttpServletRequest req) {
			//Cookie cookie = new Cookie("test" , "연습");
				
			
			return req.getCookies();
		}
		
		
		@GetMapping("/setCookie")
		public String setCookie(HttpServletResponse res) {
				Cookie cookie = new Cookie("user" , "테스트");
				
				res.addCookie(cookie);
				
				return "boardTable";
		}
		
}
