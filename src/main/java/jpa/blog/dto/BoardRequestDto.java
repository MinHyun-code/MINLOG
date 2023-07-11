package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardRequestDto {

	private int boardSeq;			// �Ϸù�ȣ
	private String title;			// ����
	private String content;			// ����
	private int menuSeq;
	private String regUserId;		// �����
	private LocalDateTime regDate;  // �������
	private LocalDateTime upDate; 	// ��������
	private String delYn; 			// ��������
	private LocalDateTime delDate; 	// ��������
	private String thumbnail;		// ����� �̹���
	private String thumbnail_txt;	// ����� �ؽ�Ʈ
	private String openYn;			// ��������
	
	public Board toEntity() {
		Board board = Board.builder()
				.boardSeq(boardSeq)
				.title(title)
				.content(content)
				.menuSeq(menuSeq)
				.regUserId(regUserId)
				.regDate(regDate)
				.upDate(upDate)
				.delYn(delYn)
				.delDate(delDate)
				.thumbnail(thumbnail)
				.thumbnail_txt(thumbnail_txt)
				.openYn(openYn)
				.build();
		return board;
	}
}
