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
		private String boardSeq;		// 일련번호
		private String title;			// 제목
		private String content;			// 내용
		private int menuSeq;
		private User userId;			// 등록자
		private LocalDateTime regDate;  // 등록일자
		private LocalDateTime modDate; 	// 수정일자
		private String delYn; 			// 삭제여부
		private LocalDateTime delDate; 	// 삭제일자
		private String thumbnail;		// 썸네일 이미지
		private String thumbnailTxt;	// 썸네일 텍스트
		private String openYn;			// 공개여부
		
		public Board toEntity() {
			Board board = Board.builder()
					.boardSeq(boardSeq)
					.title(title)
					.content(content)
					.menuSeq(menuSeq)
					.userId(userId)
					.regDate(regDate)
					.modDate(modDate)
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
