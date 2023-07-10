package jpa.blog.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jpa.blog.entity.Board;
import lombok.Data;

@Data
public class BoardResponseDto {
	private int boardSeq;			// 일련번호
	private String title;			// 제목
	private String content;			// 내용
	private int menuSeq;			// 메뉴
	private String regUserId;		// 등록자
	private String regDate;  		// 등록일자
	private String upDate; 			// 수정일자
	private String delYn; 			// 삭제여부
	private String delDate; 		// 삭제일자
	private String thumbnail;		// 썸네일
	private String openYn;			// 공개여부
	
	public BoardResponseDto(Board entity) {
		this.boardSeq = entity.getBoardSeq();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.menuSeq = entity.getMenuSeq();
		this.regUserId = entity.getRegUserId();
		this.regDate = entity.getRegDate().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		this.delYn = entity.getDelYn();
		this.thumbnail = entity.getThumbnail();
		this.openYn = entity.getOpenYn();
	}
}
