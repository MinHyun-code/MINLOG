package jpa.blog.repository;

import java.time.LocalDateTime;

public interface BoardList {
	
	String getBoardSeq();		// 일련번호
	String getTitle();			// 제목
	String getUserId();			// 등록자
	LocalDateTime getRegDate(); // 등록일자
	String getThumbnail();		// 썸네일 이미지
	String getThumbnailTxt();	// 썸네일 텍스트
	String getRegUserImg();		// 유저 이미지
	int getCommentCnt();		// 댓글 개수
	int getLikeCnt();			// 관심 개수
}
