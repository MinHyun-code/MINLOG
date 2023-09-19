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
		
		// �Խñ� ����
		Board boardDetail = boardRepository.findByBoardSeq(likeReqDto.getBoardSeq());
		// ����� ����
		User userDetail = userRepository.findByUserId(likeReqDto.getUserId());
		
		// ���� ��¥ ���ϱ�
        LocalDateTime now = LocalDateTime.now();
        
        likeReqDto.setRegDate(now);

        // ���� �޼���
        String msg = "";
        
        // ���ƿ� ���
        if(likeReqDto.getLikeYn().equals("Y")) {
        	likeReqDto.setLikeYn("N");
    		msg = "���� ��� ����Ͽ����ϴ�.";
        } 
        // ���ƿ�
        else {
            likeReqDto.setLikeYn("Y");
    		msg = "���� ����Ͽ����ϴ�.";
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
