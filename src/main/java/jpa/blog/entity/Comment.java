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
	private int commentSeq;		// ��� �ε���
	
	@Column(nullable = false)
	private String commentTxt;	// ��� ����
	
	@Column(nullable = false)
	private int depth;	// ����
	
	@Column(nullable = false)
	private int groupNum;		// ��� �׷�

	@Column(columnDefinition = "varchar(1) default 'N'", nullable = false)
	private String delYn;		// ���� ����
	
	@Column
	private LocalDateTime delDate;		// ��������
	
	@Column
	private LocalDateTime upDate;		// ��������
	
	@Column(nullable = false)
	private LocalDateTime regDate;		// �������
	
	@Column(nullable = false)
	private String regUserId;		// ����� ID
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="board_seq")
	private Board board;		// �Խñ� ��ȣ
	
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
