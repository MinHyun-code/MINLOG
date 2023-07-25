package jpa.blog.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jpa.blog.common.CommonUtil;
import jpa.blog.entity.Board;
import lombok.Data;

public class BoardResponseDto {
	
	@Data
	public static class BoardList {
		private int boardSeq;			// 일련번호
		private String title;			// 제목
		private String userId;			// 등록자
		private String regDate;  		// 등록일자
		private String thumbnail;		// 썸네일 이미지
		private String thumbnailTxt;	// 썸네일 텍스트
		private String openYn;
		
		// 메인화면 게시글 리스트
		public BoardList(Board entity) {
			this.boardSeq = entity.getBoardSeq();
			this.title = entity.getTitle();
			this.userId = entity.getUserId().getUserId();
			this.regDate = CommonUtil.boardDayDiff(entity.getRegDate());
			this.thumbnail = entity.getThumbnail();
			this.thumbnailTxt = entity.getThumbnailTxt();
			this.openYn = entity.getOpenYn();
		}
	}

	@Data
	public static class BoardDetail {
		private int boardSeq;			// 일련번호
		private String title;			// 제목
		private String content;			// 내용
		private int menuSeq;			// 메뉴
		private String userId;			// 등록자 ID
		private String userName;		// 등록자 이름
		private String userIntro;		// 등록자 소개
		private String regDate;  		// 등록일자
		private String upDate; 			// 수정일자
		private String thumbnail;		// 썸네일 이미지
		private String thumbnailTxt;	// 썸네일 텍스트
		private String openYn;			// 공개여부
		
		// 게시글 상세
		public BoardDetail(Board entity) {
			this.boardSeq = entity.getBoardSeq();
			this.title = entity.getTitle();
			this.content = entity.getContent();
			this.menuSeq = entity.getMenuSeq();
			this.userId = entity.getUserId().getUserId();
			this.userName = entity.getUserId().getUserName();
			this.userIntro = entity.getUserId().getUserIntro();
			this.regDate = CommonUtil.boardDayDiff(entity.getRegDate());
			this.thumbnail = entity.getThumbnail();
			this.thumbnailTxt = entity.getThumbnailTxt();
			this.openYn = entity.getOpenYn();
		}
	}

}
