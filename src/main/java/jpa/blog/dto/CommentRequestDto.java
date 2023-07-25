package jpa.blog.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;
import jpa.blog.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CommentRequestDto {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Create {
		
		private int commentSeq;				// 댓글 인덱스
		private String commentTxt;			// 댓글 내용
		private Board board;				// 게시글 번호
		private int boardSeq;				// 게시글 번호
		private int depth;					// 계층
		private String delYn;				// 삭제여부
		private int groupNum;				// 댓글 그룹
		private LocalDateTime regDate;		// 등록일자
		private User userId;				// 등록자 ID
		
		
		public Comment toEntity() {
			Comment commentEntity = Comment.builder()
					.commentSeq(commentSeq)
					.commentTxt(commentTxt)
					.board(board)
					.depth(depth)
					.groupNum(groupNum)
					.delYn(delYn)
					.regDate(regDate)
					.userId(userId)
					.build();
			return commentEntity;
		}
	}
}
