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
public class BoardLikeService {

	private final CommentRepository commentRepository;
	private final BoardRepository boardRepository;
	
	public String likeUpdate(String boardSeq) {
		
		String msg = "";
		
		
		
		return msg;
	}
}
