package jpa.blog.entity;

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
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentSeq;		// ��� �ε���
	
	@Column(nullable = false)
	private String commentTxt;	// ��� ����
	
	@Column(nullable = false)
	private int commentDepth;	// ����
	
	@Column(nullable = false)
	private int commentOrder;	// ��۰� ���� ����
	
	@Column(nullable = false)
	private int groupNum;		// ��� �׷�
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "board_seq")
	private Board board;		// �Խñ� ��ȣ
	
	@Builder
	public Comment(int commentSeq, String commentTxt, Board board, int commentDepth, int commentOrder, int groupNum) {
		this.commentSeq = commentSeq;
		this.commentTxt = commentTxt;
		this.board = board;
		this.commentDepth = commentDepth;
		this.commentOrder = commentOrder;
		this.groupNum = groupNum;
	}
}
