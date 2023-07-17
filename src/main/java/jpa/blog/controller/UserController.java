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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jpa.blog.dto.AjaxResult;
import jpa.blog.dto.UserRequestDto;
import jpa.blog.dto.UserResponseDto;
import jpa.blog.repository.UserRepository;
import jpa.blog.service.UserService;

@RestController
public class UserController {

	private final UserService userService;
	
	// 생성자 주입
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
//	----------------  로그인, 로그아웃  ----------------
	
	// 로그인 화면
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() { 
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		return mv;
	}
	
	// 로그인
	@RequestMapping(value = "/login/action", method = RequestMethod.POST)
	public @ResponseBody Object loginProcess() {
		return 0;
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout/action", method = RequestMethod.POST)
	public @ResponseBody Object logoutProcess() {
		return 0;
	}
	
//	----------------  회원가입  ----------------
	
	// 회원가입 화면
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUpPage() { 
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signUp/signUp");
		return mv;
	}
	
	// 회원가입
	@RequestMapping(value = "/signUp/action", method = RequestMethod.POST)
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
	@RequestMapping(value = "/myInfo", method = RequestMethod.GET)
	public ModelAndView myInfoPage(Authentication au, Model model) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myInfo/myInfo");
		return mv;
	}
}
