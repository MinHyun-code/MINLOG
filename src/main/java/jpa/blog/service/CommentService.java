package jpa.blog.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import jpa.blog.dto.CommentRequestDto;
import jpa.blog.dto.CommentResponseDto;
import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;
import jpa.blog.repository.BoardRepository;
import jpa.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final BoardRepository boardRepository;
	
	public List<CommentResponseDto.CommentList> commentList(int boardSeq) {
		
		List<Comment> commentList = commentRepository.findByComment(boardSeq);
		
		List<CommentResponseDto.CommentList> commentDtoList = new ArrayList<>();
		
		for(int i=0; i<commentList.size(); i++) {
			commentDtoList.add(new CommentResponseDto.CommentList(commentList.get(i)));
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
		
		commentDto.setBoard(boardDetail);
		
		commentRepository.save(commentDto.toEntity());
	}
}
