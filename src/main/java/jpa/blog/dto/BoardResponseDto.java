package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.Board;
import lombok.Data;

@Data
public class BoardResponseDto {
	private int boardSeq;			// 일련번호
	private String title;			// 제목
	private String content;			// 내용
	private int menuSeq;			// 메뉴
	private String regUserId;		// 등록자
	private LocalDateTime regDate;  // 등록일자
	private LocalDateTime upDate; 	// 수정일자
	private LocalDateTime delDate; 	// 삭제일자
	private String openYn;			// 공개여부
	
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
