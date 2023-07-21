package jpa.blog.controller;


import java.io.File;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import jpa.blog.common.CommonUtil;
import jpa.blog.dto.AjaxResult;
import jpa.blog.dto.BoardRequestDto;
import jpa.blog.dto.BoardResponseDto;
import jpa.blog.dto.CommentRequestDto;
import jpa.blog.dto.CommentResponseDto;
import jpa.blog.dto.FileNameModel;
import jpa.blog.entity.Board;
import jpa.blog.entity.User;
import jpa.blog.repository.BoardRepository;
import jpa.blog.security.CustomUserDetails;
import jpa.blog.service.BoardService;
import jpa.blog.service.CommentService;

@RestController
public class BoardController {
	
	private BoardService boardService;
	private CommentService commentService;
	private String path = "C:/MinLOG/";
	
	@Autowired
	public BoardController(BoardService boardService, CommentService commentService) {
		this.boardService = boardService;
		this.commentService = commentService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView board(Model model) { 
		
		List<BoardResponseDto.BoardList> boardList = boardService.boardList(); 
		model.addAttribute("boardList", boardList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/board");
		return mv;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView boardWritePage(@AuthenticationPrincipal CustomUserDetails cu, Model model, HttpServletRequest request) { 
		
		if(cu != null) {
			model.addAttribute("loginUserId", cu.getUserId());
		} 

		String status = CommonUtil.paramNullCheck(request, "status", "");
		
//		수정일 경우
		if(status.equals("R")) {
			model.addAttribute("status", status);
			int boardSeq = Integer.parseInt(request.getParameter("boardSeq"));
			BoardResponseDto.BoardDetail boardDetail = boardService.boardDetail(boardSeq);
			// 로그인한 사용자와 같을 경우
			if(cu.getUserId().equals(boardDetail.getRegUserId())) {
				// JS에서 /n을 변수에 넣을 때 줄바꿈으로 인식하여 오류 발생 - Java에서 치환 후 JS에서 치환
				String content = (boardDetail.getContent()).replaceAll("(\r\n|\r|\n|\n\r)", "<br2>");
				boardDetail.setContent(content);
				model.addAttribute("boardDetail", boardDetail);
			} else {
				model.addAttribute("status", "W");
			}
		} else {
			model.addAttribute("status", "W");
		}
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public @ResponseBody AjaxResult boardAdd(BoardRequestDto.Create boardDto, HttpServletRequest request) {
		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			String status = CommonUtil.paramNullCheck(request, "status", "");
			// 수정인 경우
			if(status.equals("R")) {
				boardService.boardUpdate(boardDto);
			} else {
				boardService.boardWrite(boardDto);
			}
			ajaxResult.setResultCode("success");
		} catch (Exception e) {
			ajaxResult.setResultCode("fail");
			// TODO: handle exception
		}
		
		return ajaxResult;
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ModelAndView boardReadPage(@AuthenticationPrincipal CustomUserDetails cu, Model model, int boardSeq) { 
		
		if(cu != null) {
			model.addAttribute("loginUserId", cu.getUserId());
		}
		model.addAttribute("boardSeq", boardSeq);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardRead");
		return mv;
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public @ResponseBody AjaxResult boardReadData(@AuthenticationPrincipal CustomUserDetails cu, int boardSeq) { 

		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			
			BoardResponseDto.BoardDetail boardDetail = boardService.boardDetail(boardSeq);
			List<CommentResponseDto.CommentList> commentList = commentService.commentList(boardSeq);
			
			ajaxResult.setResultCode("success");
			ajaxResult.setData(boardDetail);
			ajaxResult.setData2(commentList);
			
		}catch (Exception e) {
			ajaxResult.setResultCode("fail");
			// TODO: handle exception
		}
		
		return ajaxResult;
	}
	
	@RequestMapping(value="/imgSave", method = RequestMethod.POST)
	public ModelAndView writeTestPost(@RequestParam("image") MultipartFile multi, HttpServletRequest request, HttpServletResponse response) {
		
		String url = null;
		ModelAndView mv = new ModelAndView();
		
		try {
			String uploadPath = path;
			String originFilename = multi.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			long size = multi.getSize();
			FileNameModel fileNameModel = new FileNameModel();
			String saveFileName = fileNameModel.GenSaveFileName(extName);
			
			if(!multi.isEmpty()) {
				File file = new File(uploadPath, saveFileName);
				multi.transferTo(file);
				
				mv.addObject("filename", saveFileName);
				mv.addObject("uploadPath", file.getAbsolutePath());
				mv.addObject("url", uploadPath+saveFileName);
				System.out.println("url : " + uploadPath+saveFileName);
				
				mv.setViewName("image_Url_Json");
			} else {
				mv.setViewName("toast_UI_writer3");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[Error] " + e.getMessage());
		}
		return mv;
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public @ResponseBody AjaxResult boardDelete(@AuthenticationPrincipal CustomUserDetails cu, int boardSeq) { 

		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			
			boardService.boardDelete(boardSeq);
			
			ajaxResult.setResultCode("success");
		}catch (Exception e) {
			ajaxResult.setResultCode("fail");
			// TODO: handle exception
		}
		
		return ajaxResult;
	}
	
	@RequestMapping(value = "/comment/write", method = RequestMethod.POST)
	public @ResponseBody AjaxResult commentWrite(CommentRequestDto.Create commentDto) { 

		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			commentService.commentWrite(commentDto);
			
			ajaxResult.setResultCode("success");
		}catch (Exception e) {
			ajaxResult.setResultCode("fail");
			// TODO: handle exception
		}
		
		return ajaxResult;
	}
}