package jpa.blog.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa.blog.dto.CommentRequestDto;
import jpa.blog.entity.Board;
import jpa.blog.entity.BoardLike;
import jpa.blog.entity.Comment;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Integer> {
	
	
}
