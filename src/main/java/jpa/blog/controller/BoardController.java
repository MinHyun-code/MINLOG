package jpa.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("/board")
	public String board() { 
		return "board/board"; 
	}

	@GetMapping("/board/detail")
	public String boardDetail() { 
		return "board/board_detail"; 
	}
}
