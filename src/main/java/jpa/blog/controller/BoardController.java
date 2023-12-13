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
import jpa.blog.dto.LikeRequestDto;
import jpa.blog.dto.UserResponseDto;
import jpa.blog.entity.Board;
import jpa.blog.entity.BoardLike;
import jpa.blog.entity.User;
import jpa.blog.repository.BoardRepository;
import jpa.blog.repository.CommentList;
import jpa.blog.security.CustomUserDetails;
import jpa.blog.service.BoardLikeService;
import jpa.blog.service.BoardService;
import jpa.blog.service.CommentService;
import jpa.blog.service.ImageService;
import jpa.blog.service.UserService;

@RestController
public class BoardController {
	
	private BoardService boardService;
	private CommentService commentService;
	private UserService userService;
	private ImageService imageService;
	private BoardLikeService boardLikeService;
	

	static String os = System.getProperty("os.name").toLowerCase();
	static String path = "C:/MinLOG/";

	@Autowired
	public BoardController(BoardService boardService, CommentService commentService, UserService userService, ImageService imageService
				, BoardLikeService boardLikeService) {
		this.boardService = boardService;
		this.commentService = commentService;
		this.userService = userService;
		this.imageService = imageService;
		this.boardLikeService = boardLikeService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView board(Model model, @AuthenticationPrincipal CustomUserDetails cu) { 
		
		List<BoardResponseDto.BoardList> boardList = boardService.boardList(); 
		model.addAttribute("boardList", boardList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/board");
		return mv;
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView boardWritePage(@AuthenticationPrincipal CustomUserDetails cu, Model model, HttpServletRequest request) { 
		
		if(cu != null) {
			model.addAttribute("loginUserId", cu.getUserId());
		} 

		String status = CommonUtil.paramNullCheck(request, "status", "");

		// 기존 임시폴더에 저장된 이미지 삭제
		File tempFolder = new File("C:/MinLOG/board/temp/" + (String)cu.getUserId());

		if(!os.contains("win")) {
			tempFolder = new File("../../../MINLOG_IMG/board/temp/" + (String)cu.getUserId());
		}

		imageService.delete(tempFolder.toString());

		String boardSeq = request.getParameter("boardSeq");
		
		model.addAttribute("boardSeq", boardSeq);
		model.addAttribute("status", status);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "/write/data", method = RequestMethod.POST)
	public @ResponseBody AjaxResult boardAdd(@AuthenticationPrincipal CustomUserDetails cu, BoardRequestDto.Create boardDto, HttpServletRequest request) {
		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			String status = CommonUtil.paramNullCheck(request, "status", "");
			
			// 수정인 경우
			if(status.equals("R")) {
				boardService.boardUpdate(boardDto);
			} else {
				boardService.boardWrite(boardDto, (String) cu.getUserId());
			}
			ajaxResult.setResultCode("success");
		} catch (Exception e) {
			ajaxResult.setResultCode("fail");
			// TODO: handle exception
		}
		
		return ajaxResult;
	}
	
	@RequestMapping(value="/imgSave", method = RequestMethod.POST)
	public ModelAndView writeTestPost(@RequestParam("image") MultipartFile multi, HttpServletRequest request, HttpServletResponse response) {
		
		String url = null;
		ModelAndView mv = new ModelAndView();
		
		if(!os.contains("win")) {
			path = "../../../MINLOG_IMG";
		}
		
		try {

			String customPath = CommonUtil.paramNullCheck(request, "customPath", "");
			String uploadPath = path + customPath;
			String originFilename = multi.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			long size = multi.getSize();
			FileNameModel fileNameModel = new FileNameModel();
			String saveFileName = fileNameModel.GenSaveFileName(extName);
			
			if(!multi.isEmpty()) {
				File file = new File(uploadPath, saveFileName);

		        // 디렉토리 생성
		        boolean directoryCreated = file.mkdirs();
				
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
	
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public ModelAndView boardReadPage(@AuthenticationPrincipal CustomUserDetails cu, Model model, HttpServletRequest request) { 
		
		if(cu != null) {
			model.addAttribute("loginUserId", cu.getUserId());
		}
		String boardSeq = request.getParameter("boardSeq");
		model.addAttribute("boardSeq", boardSeq);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardRead");
		return mv;
	}
	
	@RequestMapping(value = "/read/data", method = RequestMethod.POST)
	public @ResponseBody AjaxResult boardReadData(@AuthenticationPrincipal CustomUserDetails cu, String boardSeq) { 

		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			
			// 게시글 정보 
			BoardResponseDto.BoardDetail boardDetail = boardService.boardDetail(boardSeq);
			
			// 댓글 정보
			CommentRequestDto.Create commentDto = new CommentRequestDto.Create();
			commentDto.setBoardSeq(boardSeq);
			List<CommentResponseDto.CommentList> commentList = commentService.commentList(commentDto);
			String likeYn = "N";
			if(cu != null) {
				// 관심 등록 여부
				likeYn = boardLikeService.likeInfoYn(boardSeq, String.valueOf(cu.getUserId()));
				ajaxResult.setData3(likeYn);
			}
			ajaxResult.setResultCode("success");
			ajaxResult.setData(boardDetail);
			ajaxResult.setData2(commentList);
			ajaxResult.setData3(likeYn);
			
		}catch (Exception e) {
			ajaxResult.setResultCode("fail");
			// TODO: handle exception
		}
		
		return ajaxResult;
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public @ResponseBody AjaxResult boardDelete(@AuthenticationPrincipal CustomUserDetails cu, String boardSeq) { 

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
	
	@RequestMapping(value = "/read/commentRead", method = RequestMethod.POST)
	public @ResponseBody AjaxResult commentRead(CommentRequestDto.Create commentDto) { 

		AjaxResult ajaxResult = new AjaxResult();

		try {
			List<CommentResponseDto.reCommentList> commentList = commentService.reCommentList(commentDto);

			ajaxResult.setData(commentList);
			
			ajaxResult.setResultCode("success");
		}catch (Exception e) {
			ajaxResult.setResultCode("fail");
			// TODO: handle exception
		}
		
		return ajaxResult;
	}

	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public @ResponseBody AjaxResult like(HttpServletRequest request, @AuthenticationPrincipal CustomUserDetails cu) { 

		AjaxResult ajaxResult = new AjaxResult();

		try {

			String boardSeq = CommonUtil.paramNullCheck(request, "boardSeq", "");
			String likeYn = CommonUtil.paramNullCheck(request, "likeYn", "");
			
			LikeRequestDto.Create likeReqDto = new LikeRequestDto.Create();
			
			likeReqDto.setBoardSeq(boardSeq);
			likeReqDto.setUserId((String) cu.getUserId());
			likeReqDto.setLikeYn(likeYn);
			
			String msg = boardLikeService.likeUpdate(likeReqDto);

			if(likeYn.equals("Y")) {
				likeYn = "N";
			} else {
				likeYn = "Y";
			}
			
			ajaxResult.setData(likeYn);
			
			ajaxResult.setResultMessage(msg);
			ajaxResult.setResultCode("success");
		}catch (Exception e) {
			ajaxResult.setResultMessage("관리자에게 문의 부탁드립니다.");
			ajaxResult.setResultCode("fail");
			// TODO: handle exception
		}
		
		return ajaxResult;
	}
}