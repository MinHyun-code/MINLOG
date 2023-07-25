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
		
		private int commentSeq;				// ��� �ε���
		private String commentTxt;			// ��� ����
		private Board board;				// �Խñ� ��ȣ
		private int boardSeq;				// �Խñ� ��ȣ
		private int depth;					// ����
		private String delYn;				// ��������
		private int groupNum;				// ��� �׷�
		private LocalDateTime regDate;		// �������
		private User userId;				// ����� ID
		
		
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
