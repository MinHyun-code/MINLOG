package jpa.blog.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;
import lombok.Data;

public class CommentResponseDto {

	@Data
	public static class CommentList {
		
		private int commentSeq;				// ��� �ε���
		private String commentTxt;			// ��� ����
		private int board_seq;				// �Խñ� ��ȣ
		private int depth;					// ����
		private int groupNum;				// ��� �׷�
		private String delYn;				// ���� ����
		private LocalDateTime delDate;		// ��������
		private LocalDateTime upDate;		// ��������
		private LocalDateTime regDate;		// �������
		private String regUserId;			// ����� ID
		
		public CommentList(Comment entity) {
			this.commentSeq = entity.getCommentSeq();
			this.commentTxt = entity.getCommentTxt();
			this.board_seq = entity.getBoard().getBoardSeq();
			this.depth = entity.getDepth();
			this.delYn = entity.getDelYn();
			this.upDate = entity.getUpDate();
			this.delDate = entity.getDelDate();
			this.regDate = entity.getRegDate();
			this.regUserId = entity.getRegUserId();
			this.groupNum = entity.getGroupNum();
		}
	}
}
