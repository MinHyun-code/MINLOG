package jpa.blog.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa.blog.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	@Query(value = "select b, u from BOARD b join USER u on b.userId = u.userId where b.boardSeq = ?1 ")
	Board findByBoardSeq(String boardSeq);
	
	@Query(value="SELECT b.board_seq as boardSeq, b.menu_seq as menuSeq, b.reg_date as regDate, b.thumbnail, b.thumbnail_txt as thumbnailTxt, b.title, b.user_id as userId, "
					+ "(SELECT count(*) FROM comment c WHERE c.board_seq = b.board_seq AND c.del_yn = 'N')  as commentCnt "
					+ "FROM board b "
					+ "WHERE b.del_yn = 'N' AND b.open_yn = 'Y' "
					+ "ORDER BY board_seq DESC", nativeQuery = true)
	List<BoardList> findMainBoardList();
	
	@Query(value = "SELECT CASE WHEN max(board_seq) IS NULL THEN concat(?1, ?2, ?3, '001') "
			+ "ELSE max(board_seq) + 1 END "
			+ "FROM BOARD "
			+ "WHERE "
			+ "substr(board_seq, 1, 4) = ?1 "
			+ "AND  substr(board_seq, 5, 2) = ?2 "
			+ "AND  substr(board_seq, 7, 2) = ?3 ", nativeQuery = true)
	String boardSeqCnt(String year, String month, String day);
	
}
