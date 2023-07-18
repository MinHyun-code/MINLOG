package jpa.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jpa.blog.dto.BoardResponseDto;
import jpa.blog.dto.CommentResponseDto;
import jpa.blog.entity.Comment;
import jpa.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository CommentRepository;
	
//	public List<CommentResponseDto.CommentList> commentList(int boardSeq) {
//		
//		List<Comment> commentList = CommentRepository.findByBoardSeq(boardSeq);
//		
//		List<CommentResponseDto.CommentList> commentDtoList = new ArrayList<>();
//		for(int i=0; i<commentList.size(); i++) {
//			commentDtoList.add(new CommentResponseDto.CommentList(commentList.get(i)));
//		}
//		
//		return commentDtoList;
//	}
}
