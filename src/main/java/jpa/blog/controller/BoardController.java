package jpa.blog.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jpa.blog.dto.AjaxResult;
import jpa.blog.dto.BoardRequestDto;
import jpa.blog.dto.BoardResponseDto;
import jpa.blog.entity.Board;
import jpa.blog.entity.User;
import jpa.blog.repository.BoardRepository;
import jpa.blog.security.CustomUserDetails;
import jpa.blog.service.BoardService;

@Controller
public class BoardController {
	
	private BoardService boardService;
	private BoardRepository boardRepository;
	
	@Autowired
	public BoardController(BoardService boardService, BoardRepository boardRepository) {
		this.boardService = boardService;
		this.boardRepository = boardRepository;
	}
	
	@GetMapping("/")
	public String board(Model model) { 
		
		List<Board> boardList = new ArrayList<>();
		
		boardList = boardRepository.findAll();
		
		model.addAttribute("boardList", boardList);
		
		return "board/board"; 
	}

	@GetMapping("/board/reg")
	public String boardRegPage(@AuthenticationPrincipal CustomUserDetails cu, Model model) { 
		
		if(cu != null) {
			model.addAttribute("loginUserId", cu.getUserId());
		} 
		return "board/boardReg";
	}
	
	@PostMapping("board/add")
	public @ResponseBody AjaxResult boardAdd(BoardRequestDto boardDto) {
		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			boardService.boardAdd(boardDto);
			ajaxResult.setResultCode("success");
		} catch (Exception e) {
			ajaxResult.setResultCode("fail");
			// TODO: handle exception
		}
		
		return ajaxResult;
	}
}
