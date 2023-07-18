package jpa.blog.dto;

import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;
import lombok.Data;

public class CommentResponseDto {

	@Data
	public static class CommentList {
		
		private int commentSeq;		// ��� �ε���
		private String commentTxt;	// ��� ����
		private Board board;		// �Խñ� ��ȣ
		private int commentDepth;	// ����
		private int commentOrder;	// ��۰� ���� ����
		private int groupNum;		// ��� �׷�
		
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
