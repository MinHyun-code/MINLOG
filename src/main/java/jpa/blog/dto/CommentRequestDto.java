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
		
		private int commentSeq;		// ��� �ε���
		private String commentTxt;	// ��� ����
		private Board board;		// �Խñ� ��ȣ
		private int commentDepth;	// ����
		private int commentOrder;	// ��۰� ���� ����
		private int groupNum;		// ��� �׷�
		
		
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
