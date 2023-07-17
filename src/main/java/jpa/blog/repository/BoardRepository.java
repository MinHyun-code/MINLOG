package jpa.blog.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import jpa.blog.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	Board findByBoardSeq(int boardSeq);
	
}
