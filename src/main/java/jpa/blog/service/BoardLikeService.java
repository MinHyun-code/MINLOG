package jpa.blog.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import jpa.blog.common.CommonUtil;
import jpa.blog.dto.CommentRequestDto;
import jpa.blog.dto.CommentResponseDto;
import jpa.blog.dto.LikeRequestDto;
import jpa.blog.entity.Board;
import jpa.blog.entity.BoardLike;
import jpa.blog.entity.Comment;
import jpa.blog.entity.User;
import jpa.blog.repository.BoardLikeRepository;
import jpa.blog.repository.BoardRepository;
import jpa.blog.repository.CommentList;
import jpa.blog.repository.CommentRepository;
import jpa.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardLikeService {

	private final UserRepository userRepository;
	private final CommentRepository commentRepository;
	private final BoardRepository boardRepository;
	private final BoardLikeRepository boardLikeRepository;
	
	public String likeUpdate(LikeRequestDto.Create likeReqDto) {
		
		// 게시글 정보
		Board boardDetail = boardRepository.findByBoardSeq(likeReqDto.getBoardSeq());
		// 사용자 정보
		User userDetail = userRepository.findByUserId(likeReqDto.getUserId());
		
		// 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
        likeReqDto.setRegDate(now);

        // 리턴 메세지
        String msg = "";
        
        // 좋아요 취소
        if(likeReqDto.getLikeYn().equals("Y")) {
        	likeReqDto.setLikeYn("N");
    		msg = "관심 등록 취소하였습니다.";
        } 
        // 좋아요
        else {
            likeReqDto.setLikeYn("Y");
    		msg = "관심 등록하였습니다.";
        }
		
        likeReqDto.setBoard(boardDetail);
        likeReqDto.setUser(userDetail);
        
        BoardLike likeDto = likeReqDto.toEntity();
        boardLikeRepository.save(likeDto);
        
		return msg;
	}
	
	public String likeInfoYn(String board_seq, String user_id) {
		
		String likeYn = boardLikeRepository.likeInfoYn(board_seq, user_id);
		String result = "N";
		
		if(likeYn != null) {
			if(likeYn.equals("Y")) {
				result = "Y";
			}
		}		
		return result;
	}
}