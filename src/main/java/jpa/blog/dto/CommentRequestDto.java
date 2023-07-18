package jpa.blog.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;
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
		
		private int commentSeq;		// ´ñ±Û ÀÎµ¦½º
		private String commentTxt;	// ´ñ±Û ³»¿ë
		private Board board;		// °Ô½Ã±Û ¹øÈ£
		private int commentDepth;	// °èÃþ
		private int commentOrder;	// ´ñ±Û°ú ´ë´ñ±Û ¼ø¼­
		private int groupNum;		// ´ñ±Û ±×·ì
		
		
		public Comment toEntity() {
			Comment commentEntity = Comment.builder()
					.commentSeq(commentSeq)
					.commentTxt(commentTxt)
					.board(board)
					.commentDepth(commentDepth)
					.commentOrder(commentOrder)
					.groupNum(groupNum)
					.build();
			return commentEntity;
		}
	}
}
