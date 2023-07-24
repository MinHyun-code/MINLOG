package jpa.blog.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	
	@Query("select c from COMMENT c left join fetch c.board where c.board.boardSeq = ?1")
//	@Query("select c from COMMENT c left join fetch c.board where c.board.boardSeq = ?1 and c.depth=1")
    List<Comment> findByComment(int boardSeq);
}
