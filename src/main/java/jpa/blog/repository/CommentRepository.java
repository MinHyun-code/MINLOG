package jpa.blog.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa.blog.dto.CommentRequestDto;
import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	@Query(value="select c.comment_seq as commentSeq, c.comment_txt as commentTxt, c.group_num as groupNum, c.reg_date as regDate, c.depth as depth, c.user_id as userId, b.board_seq as boardSeq, count(c.group_num) as commentCnt "
					+ "from COMMENT c left join BOARD b "
					+ "on c.board_seq = b.board_seq "
					+ "join USER u "
					+ "on c.user_id = u.user_id "
					+ "where c.board_seq = ?1 "
					+ "group by c.group_num "
					+ "order by c.comment_seq", 
					nativeQuery = true)
    List<CommentList> findByComment(int boardSeq);
	
	@Query(value="select c.comment_seq as commentSeq, c.comment_txt as commentTxt, c.group_num as groupNum, c.reg_date as regDate, c.depth as depth, c.user_id as userId, b.board_seq as boardSeq "
			+ "from COMMENT c left join BOARD b "
			+ "on c.board_seq = b.board_seq "
			+ "join USER u "
			+ "on c.user_id = u.user_id "
			+ "where c.board_seq = ?1 "
			+ "and c.group_num = ?2 "
			+ "and c.depth = ?3 "
			+ "order by c.reg_date ", 
			nativeQuery = true)
	List<CommentList> findByReComment(int boardSeq, int groupNum, int depth);
	
	@Query(value="select max(group_num) from comment where board_seq = ?1", nativeQuery = true)
	int findTopGroupNum(int boardSeq);
	
	Long countByBoard(Board commentDto);
}
