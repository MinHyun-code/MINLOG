package jpa.blog.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import jpa.blog.common.CommonUtil;
import jpa.blog.dto.CommentRequestDto;
import jpa.blog.dto.CommentResponseDto;
import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;
import jpa.blog.repository.BoardRepository;
import jpa.blog.repository.CommentList;
import jpa.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final BoardRepository boardRepository;
	
	public List<CommentResponseDto.CommentList> commentList(CommentRequestDto.Create commentDto) {
	
		List<CommentList> commentList = new ArrayList<CommentList>();
	
		commentList = commentRepository.findByComment(commentDto.getBoardSeq());
		
		List<CommentResponseDto.CommentList> commentDtoList = new ArrayList<>();
		
		for(int i=0; i<commentList.size(); i++) {
			commentDtoList.add(new CommentResponseDto.CommentList(commentList.get(i)));
		}
		
		return commentDtoList;
	}
	
	public List<CommentResponseDto.reCommentList> reCommentList(CommentRequestDto.Create commentDto) {
	
		List<CommentList> commentList = new ArrayList<CommentList>();
		
		commentList = commentRepository.findByReComment(commentDto.getBoardSeq(), commentDto.getGroupNum(), commentDto.getDepth());
		
		List<CommentResponseDto.reCommentList> commentDtoList = new ArrayList<>();
		
		for(int i=0; i<commentList.size(); i++) {
			commentDtoList.add(new CommentResponseDto.reCommentList(commentList.get(i)));
		}
		
		return commentDtoList;
	}
	
	@Transactional
	public void commentWrite(CommentRequestDto.Create commentDto) {
		Board boardDetail = boardRepository.findByBoardSeq(commentDto.getBoardSeq());
		
        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
        commentDto.setRegDate(now);
        commentDto.setDelYn("N");
		
        Long cnt = commentRepository.countByBoard(boardDetail);
        
//        댓글 첫 등록 시
        if(cnt == 0) {
            commentDto.setGroupNum(1);
        } else {
        	if(commentDto.getGroupNum() == 0) {
	            // 그룹의 가장 큰 값 찾기
	            int commentGroupMax = commentRepository.findTopGroupNum(commentDto.getBoardSeq());
	            commentDto.setGroupNum(commentGroupMax + 1);
        	}
        }
        
		commentDto.setBoard(boardDetail);
		
		commentRepository.save(commentDto.toEntity());
	}
}
