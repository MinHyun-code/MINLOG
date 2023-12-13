package jpa.blog.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import jpa.blog.dto.BoardRequestDto;
import jpa.blog.dto.BoardResponseDto;
import jpa.blog.security.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Table(name="board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="board")
@DynamicUpdate	// 변경한 필드만 대응
public class Board {

	@Id
	@Column(name = "board_seq")
	private String boardSeq;		// 일련번호
	
	@Column(columnDefinition = "varchar(100)", nullable = false)
	private String title;			// 제목
	
	@Column(columnDefinition = "TEXT")
	private String content;			// 내용
	
	private int menuSeq;			// 메뉴
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User userId;			// 등록자 ID
	
	@Column(nullable = false)
	private LocalDateTime regDate;  // 등록일자
	
	private LocalDateTime upDate; 	// 수정일자
	
	@Column(columnDefinition = "varchar(1) default 'N'", nullable = false)
	private String delYn;			// 삭제여부
	
	private LocalDateTime delDate; 	// 삭제일자
	
	private String thumbnail; 		// 썸네일 이미지

	@Column(columnDefinition = "varchar(150)", nullable = false)
	private String thumbnailTxt; 	// 썸네일 텍스트
	
	@Column(columnDefinition = "varchar(1)")
	private String openYn;			// 공개여부
	
	
	// N+1 문제를 방지하기 위해 Set 사용
	@OneToMany(mappedBy = "board")
	private Set<Comment> comment = new LinkedHashSet<>();
	
	@Builder
	public Board(String boardSeq, String title, String content, int menuSeq, User userId, LocalDateTime regDate, LocalDateTime upDate, String delYn, LocalDateTime delDate, String thumbnail, String thumbnailTxt, String openYn) {
		this.boardSeq = boardSeq;
		this.title = title;
		this.content = content;
		this.menuSeq = menuSeq;
		this.userId = userId;
		this.regDate = regDate;
		this.upDate = upDate;
		this.delYn = delYn;
		this.delDate = delDate;
		this.thumbnail = thumbnail;
		this.thumbnailTxt = thumbnailTxt;
		this.openYn = openYn;
	}
	
	// 삭제여부 변경
	public void changeDelYn(String delYn, LocalDateTime delDate) {
		this.delYn = delYn;
		this.delDate = delDate;
	}
	
	// 게시글 수정
	public void changeBoard(BoardRequestDto.Create boardDto) {
		this.boardSeq = boardDto.getBoardSeq();
		this.title = boardDto.getTitle();
		this.content = boardDto.getContent();
		this.menuSeq = boardDto.getMenuSeq();
		this.upDate = boardDto.getUpDate();
		this.thumbnail = boardDto.getThumbnail();
		this.thumbnailTxt = boardDto.getThumbnailTxt();
		this.openYn = boardDto.getOpenYn();
	}
}
