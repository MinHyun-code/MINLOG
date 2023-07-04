package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.Board;
import lombok.Data;

@Data
public class BoardResponseDto {
	private int boardSeq;			// �Ϸù�ȣ
	private String title;			// ����
	private String content;			// ����
	private int menuSeq;			// �޴�
	private String regUserId;		// �����
	private LocalDateTime regDate;  // �������
	private LocalDateTime upDate; 	// ��������
	private LocalDateTime delDate; 	// ��������
	private String openYn;			// ��������
	
	public BoardResponseDto(Board entity) {
		this.boardSeq = entity.getBoardSeq();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.menuSeq = entity.getMenuSeq();
		this.regUserId = entity.getRegUserId();
		this.regDate = entity.getRegDate();
		this.upDate = entity.getUpDate();
		this.delDate = entity.getDelDate();
		this.openYn = entity.getOpenYn();
	}
}
