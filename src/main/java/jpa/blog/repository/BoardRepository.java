package jpa.blog.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.blog.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	Board findByBoardSeq(int boardSeq);
	
	List<Board> findByDelYnAndOpenYnOrderByBoardSeqDesc(String delYn, String openYn);
	
}
