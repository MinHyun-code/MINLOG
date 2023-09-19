package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.Board;
import jpa.blog.entity.BoardLike;
import jpa.blog.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LikeRequestDto {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Create {

		private Board board;				// 게시글 번호
		private String boardSeq;			// 게시글 번호
		private User user;					// 사용자 ID
		private String userId;				// 사용자 ID
		private String likeYn;				// 좋아요 유무
		private LocalDateTime regDate;		// 등록일자
		
		
		public BoardLike toEntity() {
			BoardLike boardLikeEntity = BoardLike.builder()
					.board(board)
					.user(user)
					.likeYn(likeYn)
					.regDate(regDate)
					.build();
			return boardLikeEntity;
		}
	}
	
}
