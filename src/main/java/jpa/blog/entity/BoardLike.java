package jpa.blog.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name="BOARD_LIKE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="BOARD_LIKE")
@IdClass(BoardLikeKey.class)
public class BoardLike implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@Id
	@JoinColumn(name="board_seq")
	private Board board;			// 게시글 번호

	@OneToOne(fetch = FetchType.LAZY)
	@Id
	@JoinColumn(name="user_id")
	private User user;			// 사용자 ID

	@Column(name="like_yn")
	private String likeYn; 			// 상태 값 (좋아요:Y, 디폴트:N)

	@Column(nullable = false)
	private LocalDateTime regDate;	// 등록일자
	
	@Builder
	public BoardLike(Board board, User user, String likeYn, LocalDateTime regDate) {
		this.board = board;
		this.user = user;
		this.likeYn = likeYn;
		this.regDate = regDate;
	}
}