package jpa.blog.repository;



import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa.blog.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	@Query(value = "select b, u from BOARD b join USER u on b.userId = u.userId where b.boardSeq = ?1 ")
	Board findByBoardSeq(String boardSeq);
	
	List<Board> findByDelYnAndOpenYnOrderByBoardSeqDesc(String delYn, String openYn);
	
	@Query(value = "SELECT CASE WHEN max(board_seq) IS NULL THEN concat(?1, ?2, ?3, '001') "
			+ "ELSE max(board_seq) + 1 END "
			+ "FROM BOARD "
			+ "WHERE "
			+ "substr(board_seq, 1, 4) = ?1 "
			+ "AND  substr(board_seq, 5, 2) = ?2 "
			+ "AND  substr(board_seq, 7, 2) = ?3 ", nativeQuery = true)
	String boardSeqCnt(String year, String month, String day);
	
}
