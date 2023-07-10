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

	private int boardSeq;			// 일련번호
	private String title;			// 제목
	private String content;			// 내용
	private int menuSeq;
	private String regUserId;		// 등록자
	private LocalDateTime regDate;  // 등록일자
	private LocalDateTime upDate; 	// 수정일자
	private String delYn; 			// 삭제여부
	private LocalDateTime delDate; 	// 삭제일자
	private String thumbnail;
	private String openYn;			// 공개여부
	
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
				.openYn(openYn)
				.build();
		return board;
	}
}
