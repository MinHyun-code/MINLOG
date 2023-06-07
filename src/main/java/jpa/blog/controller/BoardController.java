package jpa.blog.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jpa.blog.dto.UserDto;

@Controller
public class BoardController {
	@GetMapping("/board")
	public String board(Authentication au, Model model) { 
		
		if(au != null) {
			UserDetails loginUser = (UserDetails) au.getPrincipal();
			model.addAttribute("loginUser", loginUser);
		}
		return "board/board"; 
	}

	@GetMapping("/board/detail")
	public String boardDetail() { 
		return "board/board_detail"; 
	}
}
