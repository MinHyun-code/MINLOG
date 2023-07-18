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
	private int commentSeq;		// ´ñ±Û ÀÎµ¦½º
	
	@Column(nullable = false)
	private String commentTxt;	// ´ñ±Û ³»¿ë
	
	@Column(nullable = false)
	private int commentDepth;	// °èÃþ
	
	@Column(nullable = false)
	private int commentOrder;	// ´ñ±Û°ú ´ë´ñ±Û ¼ø¼­
	
	@Column(nullable = false)
	private int groupNum;		// ´ñ±Û ±×·ì
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "board_seq")
	private Board board;		// °Ô½Ã±Û ¹øÈ£
	
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
