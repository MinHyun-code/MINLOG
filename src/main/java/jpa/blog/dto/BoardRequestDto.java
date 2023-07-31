package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.Board;
import jpa.blog.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoardRequestDto {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Create {
		private String boardSeq;		// �Ϸù�ȣ
		private String title;			// ����
		private String content;			// ����
		private int menuSeq;
		private User userId;			// �����
		private LocalDateTime regDate;  // �������
		private LocalDateTime upDate; 	// ��������
		private String delYn; 			// ��������
		private LocalDateTime delDate; 	// ��������
		private String thumbnail;		// ����� �̹���
		private String thumbnailTxt;	// ����� �ؽ�Ʈ
		private String openYn;			// ��������
		
		public Board toEntity() {
			Board board = Board.builder()
					.boardSeq(boardSeq)
					.title(title)
					.content(content)
					.menuSeq(menuSeq)
					.userId(userId)
					.regDate(regDate)
					.upDate(upDate)
					.delYn(delYn)
					.delDate(delDate)
					.thumbnail(thumbnail)
					.thumbnailTxt(thumbnailTxt)
					.openYn(openYn)
					.build();
			return board;
		}
	}
}
