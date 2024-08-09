package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BoardTableDTO;
import com.app.dto.BoardUserDTO;
import com.app.dto.BoardUserResultDTO;
import com.app.mapper.CompanyMapper;
import com.app.mapper.CompanyUserMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyMapper cm;

	public List<BoardTableDTO> boardTable(BoardTableDTO boardTableDTO){
		List<BoardTableDTO> lb = cm.BoardTable(boardTableDTO);
		//System.out.println("service:::::::::::  " + lb);
		return lb;
	}
	
	public String check(int noticeNo, HttpServletRequest req) {
		HttpSession http = req.getSession();
		if(http.getAttribute("userNo") != null) {
			int userNo = Integer.parseInt(http.getAttribute("userNo").toString());
			int nUserNo = cm.check(noticeNo);
			if(userNo == nUserNo) {
				return noticeNo + "해당 글 접근 가능";
			}
		}
		return noticeNo + "해당 글 접근 불가";
	}
	
	@Autowired
	private CompanyUserMapper cum;
	
	public BoardUserResultDTO findByUser(BoardUserDTO userDTO) {
		userDTO = cum.findByUser(userDTO);
		boolean status = false;
		String message = "유효한 사용자가 아닙니다";
		if(userDTO != null) {
			status = true;
			message = userDTO.getUserNm() + "님 환영합니다";
		}
		return BoardUserResultDTO.builder()
				.status(status)
				.message(message)
				.userDTO(userDTO)
				.build();
	}

	
}
