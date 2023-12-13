package jpa.blog.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa.blog.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	@Query(value = "select b, u from board b join user u on b.userId = u.userId where b.boardSeq = ?1 ")
	Board findByBoardSeq(String boardSeq);
	
	@Query(value="SELECT b.board_seq as boardSeq, b.menu_seq as menuSeq, b.reg_date as regDate, b.thumbnail, b.thumbnail_txt as thumbnailTxt, b.title, b.user_id as userId, u.user_img as regUserImg, "
					+ "(SELECT count(*) FROM comment c WHERE c.board_seq = b.board_seq AND c.del_yn = 'N')  as commentCnt, "
					+ "(SELECT count(*) FROM board_like l WHERE l.board_seq = b.board_seq AND l.like_yn = 'Y') as likeCnt "
					+ "FROM board b "
					+ "JOIN user u ON b.user_id = u.user_id "
					+ "WHERE b.del_yn = 'N' AND b.open_yn = 'Y' AND u.status = 0 " 
					+ "ORDER BY board_seq DESC", nativeQuery = true)
	List<BoardList> findMainBoardList();
	
	@Query(value = "SELECT CASE WHEN max(board_seq) IS NULL THEN concat(?1, ?2, ?3, '001') "
			+ "ELSE max(board_seq) + 1 END "
			+ "FROM board "
			+ "WHERE "
			+ "substr(board_seq, 1, 4) = ?1 "
			+ "AND  substr(board_seq, 5, 2) = ?2 "
			+ "AND  substr(board_seq, 7, 2) = ?3 ", nativeQuery = true)
	String boardSeqCnt(String year, String month, String day);
	
}
