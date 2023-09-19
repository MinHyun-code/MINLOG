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

		private Board board;				// �Խñ� ��ȣ
		private String boardSeq;			// �Խñ� ��ȣ
		private User user;					// ����� ID
		private String userId;				// ����� ID
		private String likeYn;				// ���ƿ� ����
		private LocalDateTime regDate;		// �������
		
		
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
