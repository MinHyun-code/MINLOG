package jpa.blog.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jpa.blog.dto.AjaxResult;
import jpa.blog.dto.UserRequestDto;
import jpa.blog.dto.UserResponseDto;
import jpa.blog.repository.UserRepository;
import jpa.blog.service.UserService;

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
	
//	----------------  로그인, 로그아웃  ----------------
	
	// 로그인 화면
	@GetMapping("/login")
	public String loginPage() { 
		return "login/login"; 
	}
	
	// 로그인
	@PostMapping("/login/action")
	public @ResponseBody Object loginProcess() {
		return 0;
	}
	
	// 로그아웃
	@PostMapping("/logout/action")
	public @ResponseBody Object logoutProcess() {
		return 0;
	}
	
//	----------------  회원가입  ----------------
	
	// 회원가입 화면
	@GetMapping("/signUp")
	public String signUpPage() { 
		return "signUp/signUp"; 
	}
	
	// 회원가입
	@PostMapping("/signUp/action")
	public @ResponseBody AjaxResult signUp(UserRequestDto dto) {
		AjaxResult ajaxResult = new AjaxResult();
		boolean existYn = userService.findByUserId(dto.getUserId());
		
		if(existYn == true) {
			ajaxResult.setResultCode("fail");
			ajaxResult.setResultMessage("해당 이메일로 생성된 계정이 있습니다.");
			return ajaxResult;
		} else {
			userService.signUp(dto);
			ajaxResult.setResultCode("success");
			ajaxResult.setResultMessage("회원가입 되었습니다.");
			return ajaxResult;
		}
	}
	
//	----------------  마이페이지  ----------------
	
	// 내정보 화면
	@GetMapping("/myInfo")
	public String myInfoPage(Authentication au, Model model) {
		
		return "myInfo/myInfo";
	}
}
