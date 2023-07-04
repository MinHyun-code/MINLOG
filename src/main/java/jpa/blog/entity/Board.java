package jpa.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jpa.blog.security.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Table(name="BOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int boardSeq;			// 일련번호
	
//	@NonNull
	private String title;			// 제목
	
	@Column(columnDefinition = "TEXT")
	private String content;			// 내용
	
	private int menuSeq;			// 메뉴
	
//	@NonNull
	private String regUserId;		// 등록자
	
//	@NonNull
	private LocalDateTime regDate;  // 등록일자
	
	private LocalDateTime upDate; 	// 수정일자
	
	private LocalDateTime delDate; 	// 삭제일자
	
	@NonNull
	private String openYn;			// 공개여부
	
	
	@Builder
	public Board(int boardSeq, String title, String content, int menuSeq, String regUserId, LocalDateTime regDate, LocalDateTime upDate, LocalDateTime delDate, String openYn) {
		this.boardSeq = boardSeq;
		this.title = title;
		this.content = content;
		this.menuSeq = menuSeq;
		this.regUserId = regUserId;
		this.regDate = regDate;
		this.upDate = upDate;
		this.delDate = delDate;
		this.openYn = openYn;
	}
}
