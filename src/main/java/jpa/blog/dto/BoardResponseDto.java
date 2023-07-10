package jpa.blog.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jpa.blog.entity.Board;
import lombok.Data;

@Data
public class BoardResponseDto {
	private int boardSeq;			// �Ϸù�ȣ
	private String title;			// ����
	private String content;			// ����
	private int menuSeq;			// �޴�
	private String regUserId;		// �����
	private String regDate;  		// �������
	private String upDate; 			// ��������
	private String delYn; 			// ��������
	private String delDate; 		// ��������
	private String thumbnail;		// �����
	private String openYn;			// ��������
	
	public BoardResponseDto(Board entity) {
		this.boardSeq = entity.getBoardSeq();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.menuSeq = entity.getMenuSeq();
		this.regUserId = entity.getRegUserId();
		this.regDate = entity.getRegDate().format(DateTimeFormatter.ofPattern("yyyy�� MM�� dd��"));
		this.delYn = entity.getDelYn();
		this.thumbnail = entity.getThumbnail();
		this.openYn = entity.getOpenYn();
	}
}
