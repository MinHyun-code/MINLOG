package jpa.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Table(name="COMMENT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="COMMENT")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentSeq;		// 댓글 인덱스
	
	@Column(nullable = false)
	private String commentTxt;	// 댓글 내용
	
	@Column(nullable = false)
	private int depth;	// 계층
	
	@Column(nullable = false)
	private int groupNum;		// 댓글 그룹

	@Column(columnDefinition = "varchar(1) default 'N'", nullable = false)
	private String delYn;		// 삭제 여부
	
	@Column
	private LocalDateTime delDate;		// 삭제일자
	
	@Column
	private LocalDateTime upDate;		// 수정일자
	
	@Column(nullable = false)
	private LocalDateTime regDate;		// 등록일자
	
	@Column(nullable = false)
	private String regUserId;		// 등록자 ID
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="board_seq")
	private Board board;		// 게시글 번호
	
	@Builder
	public Comment(int commentSeq, String commentTxt, Board board, int depth, int groupNum, String delYn, LocalDateTime delDate, LocalDateTime upDate, LocalDateTime regDate, String regUserId) {
		this.commentSeq = commentSeq;
		this.commentTxt = commentTxt;
		this.board =board;
		this.depth = depth;
		this.delYn = delYn;
		this.upDate = upDate;
		this.delDate = delDate;
		this.regDate = regDate;
		this.regUserId = regUserId;
		this.groupNum = groupNum;
	}
	
	public Board getBoard() {
		return board;
	}
}
