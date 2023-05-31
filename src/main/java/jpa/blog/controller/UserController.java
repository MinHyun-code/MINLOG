package jpa.blog.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jpa.blog.controller.model.UserService;
import jpa.blog.dto.UserDto;
import jpa.blog.dto.UserResponseDto;
import jpa.blog.entity.User;
import jpa.blog.entity.UserRepository;

@Controller
public class UserController {

	private final UserService userService;
	private final UserRepository userRepository;
	
	// 생성자 주입
	@Autowired
	public UserController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}
	
	@GetMapping("test")
	public List<UserResponseDto> findAll() {
		return userService.findAll();
	}
	
	// 로그인 화면
	@GetMapping("/login")
	public String login() { 
		return "login/login"; 
	}
	
	// 회원가입 화면
	@GetMapping("/signUp")
	public String signUp() { 
		return "login/signUp"; 
	}
//	
	@PostMapping("/login/action")
	public @ResponseBody Object loginProcess(HttpServletRequest request) {
		
		
		
		return 0;
	}
	
//	
	@PostMapping("/join/action")
	public @ResponseBody Object join(HttpServletRequest request, UserDto userDto) {
		Optional<User> userInfo = userRepository.findByUserId(userDto.getUserId());
		
		if(userInfo.isPresent()) {
			return 1;
		} else {
			userService.join(userDto);
			return 0;
		}
	}
	
	
	@RequestMapping(value="/sample/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView dashboard() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sample/dashboard");
		return mv;
	}
	
}
