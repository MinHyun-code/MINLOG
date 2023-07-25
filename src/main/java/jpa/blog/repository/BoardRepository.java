package jpa.blog.repository;



import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa.blog.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	@Query(value = "select b, u from BOARD b join USER u on b.userId = u.userId where b.boardSeq = ?1 ")
	Board findByBoardSeq(int boardSeq);
	
	List<Board> findByDelYnAndOpenYnOrderByBoardSeqDesc(String delYn, String openYn);
	
}
