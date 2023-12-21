package jpa.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jpa.blog.dto.AjaxResult;
import jpa.blog.dto.UserRequestDto;
import jpa.blog.security.CustomUserDetails;
import jpa.blog.service.UserService;

@RestController
public class SettingController {
	
	private final UserService userService;
	
	// 생성자 주입
	@Autowired
	public SettingController(UserService userService) {
		this.userService = userService;
	}
	
	// 설정 화면
	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public ModelAndView settingPage(Authentication au, Model model) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("setting/setting");
		return mv;
	}
	
	// 개인정보 수정 화면
	@RequestMapping(value = "/myInfo", method = RequestMethod.GET)
	public ModelAndView myInfoPage(Authentication au, Model model) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("setting/myInfo");
		return mv;
	}
	
	// 개인정보 가져오기
	@RequestMapping(value = "/myInfo", method = RequestMethod.POST)
	public @ResponseBody AjaxResult userInfo(@AuthenticationPrincipal CustomUserDetails cu) {
		
		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			ajaxResult.setData(userService.userInfo((cu.getUserId()).toString()));
		} catch (Exception e) {
			ajaxResult.setResultCode("fail");
		}
		
		return ajaxResult;
	}
	
	// 개인정보 업데이트
	@RequestMapping(value = "/myInfo/update", method = RequestMethod.POST)
	public @ResponseBody AjaxResult userInfoUpdate(@AuthenticationPrincipal CustomUserDetails cu, UserRequestDto.Create dto) {
		
		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			userService.userInfoUpdate(dto);
			ajaxResult.setResultCode("success");
			ajaxResult.setResultMessage("변경 완료하였습니다.");
		} catch (Exception e) {
			ajaxResult.setResultCode("fail");
		}
		
		return ajaxResult;
	}
}
