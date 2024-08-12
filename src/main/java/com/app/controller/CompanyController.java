package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dto.BoardTableDTO;
import com.app.dto.BoardUserDTO;
import com.app.dto.BoardUserResultDTO;
import com.app.dto.RoleDTO;
import com.app.service.CompanyService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService cs;
	
	@GetMapping("/")
	public String boardTable(Model model ,BoardTableDTO boardTableDTO) {
		
		model.addAttribute("boards", cs.boardTable(boardTableDTO));
		//System.out.println("Controller:::::::::::::: " +cs.boardTable(boardTableDTO));
		return "boardTable";
	}
	//접근 권한 설정
	@ResponseBody
	@GetMapping("/check")
	public String check(@RequestParam("noticeNo") int noticeNo, HttpServletRequest req) {
		
		return cs.check(noticeNo, req);
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//@ResponseBody
	@PostMapping("/login")
	public String login(@ModelAttribute BoardUserDTO userDTO, HttpServletRequest req) {
		BoardUserResultDTO burDTO = cs.findByUser(userDTO);
		if(burDTO.isStatus()) {
			HttpSession http = req.getSession();
			http.setAttribute("userNo", burDTO.getUserDTO().getUserNo());
			http.setAttribute("userNm", burDTO.getUserDTO().getUserNm());
			http.setAttribute("userRoles", burDTO.getUserDTO().getUserRoles());
			return "redirect:/";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/";
	}
	
	@ResponseBody
	@PostMapping("/info")
	public BoardUserResultDTO info(HttpServletRequest req) {
		HttpSession http = req.getSession();
		boolean status = false;
		String message = "사용자 없음";
		BoardUserDTO userDTO = null;
		if(http.getAttribute("userNo") != null) {
			userDTO = new BoardUserDTO();
			userDTO.setUserNo(Integer.parseInt(http.getAttribute("userNo").toString()));
			userDTO.setUserNm(http.getAttribute("userNm").toString());
			userDTO.setUserRoles((List<RoleDTO>) http.getAttribute("userRoles"));
			status = true;
			message = userDTO.getUserNm() + "님 환영합니다";
		}
		return BoardUserResultDTO.builder()
				.status(status)
				.message(message)
				.userDTO(userDTO)
				.build();
	}
	@GetMapping("/test1")
	public String test() {
		return "test";
	}
	

}
