package jpa.blog.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.blog.dto.BoardRequestDto;
import jpa.blog.dto.BoardResponseDto;
import jpa.blog.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	Board findByBoardSeq(int boardSeq);
	
}
