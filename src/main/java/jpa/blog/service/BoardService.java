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
	public void boardWrite(BoardRequestDto.Create boardDto) {
		
        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
        boardDto.setRegDate(now);
        boardDto.setDelYn("N");

        boardRepository.save(boardDto.toEntity());
	}
	
	public List<BoardResponseDto.BoardList> boardList() {

		// 등록 순서대로 보여주기 (나중에 등록된 것 위로)
		List<Board> boardList = boardRepository.findByDelYnAndOpenYnOrderByBoardSeqDesc("N", "Y");
		List<BoardResponseDto.BoardList> boardDtoList = new ArrayList<>();
		for(int i=0; i<boardList.size(); i++) {
			boardDtoList.add(new BoardResponseDto.BoardList(boardList.get(i)));
		}
		return boardDtoList;
	}
	
	public BoardResponseDto.BoardDetail boardDetail(int boardSeq) {

		BoardResponseDto.BoardDetail boardDetail = new BoardResponseDto.BoardDetail(boardRepository.findByBoardSeq(boardSeq));
		
		return boardDetail;
	}
	
	
	@Transactional
    public void boardDelete(int boardSeq) {
    	
    	Board boardDetail = boardRepository.findByBoardSeq(boardSeq);

        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
    	boardDetail.changeDelYn("Y", now);
    }
	
	@Transactional
	public void boardUpdate(BoardRequestDto.Create boardDto) {
		Board boardInfo = boardRepository.findByBoardSeq(boardDto.getBoardSeq());

        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
        boardDto.setUpDate(now);
        
		boardInfo.changeBoard(boardDto);
	}
}
