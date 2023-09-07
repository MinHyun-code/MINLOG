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
		
		private Board board;
		private User userId;
		private String likeYn;
		private LocalDateTime regDate;
		
		public BoardLike toEntity() {
			BoardLike likeEntity = BoardLike.builder()
					.board(board)
					.userId(userId)
					.likeYn(likeYn)
					.regDate(regDate)
					.build();
			return likeEntity;
		}
	}
	
}
