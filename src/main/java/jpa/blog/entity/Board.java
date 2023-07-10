package jpa.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate	// 변경한 필드만 대응
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
	
	private String delYn;			// 삭제여부
	
	private LocalDateTime delDate; 	// 삭제일자
	
	@NonNull
	private String openYn;			// 공개여부
	
	
	@Builder
	public Board(int boardSeq, String title, String content, int menuSeq, String regUserId, LocalDateTime regDate, LocalDateTime upDate, String delYn, LocalDateTime delDate, String openYn) {
		this.boardSeq = boardSeq;
		this.title = title;
		this.content = content;
		this.menuSeq = menuSeq;
		this.regUserId = regUserId;
		this.regDate = regDate;
		this.upDate = upDate;
		this.delYn = delYn;
		this.delDate = delDate;
		this.openYn = openYn;
	}
}
