package jpa.blog.dto;

import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;
import lombok.Data;

public class CommentResponseDto {

	@Data
	public static class CommentList {
		
		private int commentSeq;		// ´ñ±Û ÀÎµ¦½º
		private String commentTxt;	// ´ñ±Û ³»¿ë
		private Board board;		// °Ô½Ã±Û ¹øÈ£
		private int commentDepth;	// °èÃþ
		private int commentOrder;	// ´ñ±Û°ú ´ë´ñ±Û ¼ø¼­
		private int groupNum;		// ´ñ±Û ±×·ì
		
		public CommentList(Comment entity) {
			this.commentSeq = entity.getCommentSeq();
			this.commentTxt = entity.getCommentTxt();
			this.board = entity.getBoard();
			this.commentDepth = entity.getCommentDepth();
			this.commentOrder = entity.getCommentOrder();
			this.groupNum = entity.getGroupNum();
		}
	}
}
