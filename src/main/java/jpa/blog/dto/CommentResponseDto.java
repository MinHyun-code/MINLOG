package jpa.blog.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;
import lombok.Data;

public class CommentResponseDto {

	@Data
	public static class CommentList {
		
		private int commentSeq;				// 댓글 인덱스
		private String commentTxt;			// 댓글 내용
		private int board_seq;				// 게시글 번호
		private int depth;					// 계층
		private int groupNum;				// 댓글 그룹
		private String delYn;				// 삭제 여부
		private LocalDateTime delDate;		// 삭제일자
		private LocalDateTime upDate;		// 수정일자
		private LocalDateTime regDate;		// 등록일자
		private String regUserId;			// 등록자 ID
		
		public CommentList(Comment entity) {
			this.commentSeq = entity.getCommentSeq();
			this.commentTxt = entity.getCommentTxt();
			this.board_seq = entity.getBoard().getBoardSeq();
			this.depth = entity.getDepth();
			this.delYn = entity.getDelYn();
			this.upDate = entity.getUpDate();
			this.delDate = entity.getDelDate();
			this.regDate = entity.getRegDate();
			this.regUserId = entity.getRegUserId();
			this.groupNum = entity.getGroupNum();
		}
	}
}
