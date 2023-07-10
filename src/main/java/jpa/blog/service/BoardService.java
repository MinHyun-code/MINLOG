package jpa.blog.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jpa.blog.dto.BoardRequestDto;
import jpa.blog.dto.BoardResponseDto;
import jpa.blog.entity.Board;
import jpa.blog.repository.BoardRepository;
import jpa.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	@Transactional
	public void boardWrite(BoardRequestDto boardDto) {
		
        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
        boardDto.setRegDate(now);
        boardDto.setDelYn("N");

        boardRepository.save(boardDto.toEntity());
	}
	

    public void boardDelete(int boardSeq) {
    	
//    	Board board = boardRepository.findByBoardSeq(boardSeq);
//    	
//    	board.
//    	
//    	board.setDelYn("Y");
//
//		boardRepository.save(board.toEntity());
    }
	
}
