package jpa.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

//	List<Comment> findByBoardSeq(int boardSeq);

}
