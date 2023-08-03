package jpa.blog.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;

import jpa.blog.common.CommonUtil;
import jpa.blog.entity.Board;
import jpa.blog.entity.Comment;
import lombok.Data;

public class CommentResponseDto {

	@Data
	public static class CommentList {
		
		private int commentSeq;				// 댓글 인덱스
		private String commentTxt;			// 댓글 내용
		private String board_seq;			// 게시글 번호
		private int depth;					// 계층
		private int groupNum;				// 댓글 그룹
		private String delYn;				// 삭제 여부
		private LocalDateTime delDate;		// 삭제일자
		private LocalDateTime upDate;		// 수정일자
		private String regDate;				// 등록일자
		private String userImg;				// 등록자 이미지
		private String userId;				// 등록자 ID
		
		private int commentCnt;			// 대댓글 개수
		
		
		// 게시글 조회 페이지 (로드 시)
		public CommentList(jpa.blog.repository.CommentList commentList) {
			this.commentSeq = commentList.getCommentSeq();
			this.commentTxt = commentList.getCommentTxt();
			this.board_seq = commentList.getBoardSeq();
			this.regDate = CommonUtil.commentDayDiff(commentList.getRegDate());
			this.depth = commentList.getDepth();
			this.userId = commentList.getUserId();
			this.userImg = commentList.getUserImg();
			this.groupNum = commentList.getGroupNum();
			if(commentList.getCommentCnt() > 0) {
				this.commentCnt = commentList.getCommentCnt();
			}
		}
	}
	
	@Data
	public static class reCommentList {
		
		private int commentSeq;				// 댓글 인덱스
		private String commentTxt;			// 댓글 내용
		private String board_seq;			// 게시글 번호
		private int depth;					// 계층
		private int groupNum;				// 댓글 그룹
		private String regDate;				// 등록일자
		private String userId;				// 등록자 ID
		private String userImg;				// 등록자 이미지
		
		// 게시글 조회 페이지 (대댓글 조회 시)
		public reCommentList(jpa.blog.repository.CommentList commentList) {
			this.commentSeq = commentList.getCommentSeq();
			this.commentTxt = commentList.getCommentTxt();
			this.board_seq = commentList.getBoardSeq();
			this.regDate = CommonUtil.commentDayDiff(commentList.getRegDate());
			this.depth = commentList.getDepth();
			this.userImg = commentList.getUserImg();
			this.userId = commentList.getUserId();
			this.groupNum = commentList.getGroupNum();
		}
	}
}
