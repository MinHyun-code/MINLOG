package jpa.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa.blog.entity.BoardLike;
import jpa.blog.entity.BoardLikeKey;

public interface BoardLikeRepository extends JpaRepository<BoardLike, BoardLikeKey> {
	
	@Query(value = "select likeYn from BOARD_LIKE where board_seq = ?1 and user_id = ?2")
	String likeInfoYn(String board_seq, String user_id);
}
