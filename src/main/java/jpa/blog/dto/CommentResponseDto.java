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
		
		private int commentSeq;				// ��� �ε���
		private String commentTxt;			// ��� ����
		private String board_seq;			// �Խñ� ��ȣ
		private int depth;					// ����
		private int groupNum;				// ��� �׷�
		private String delYn;				// ���� ����
		private LocalDateTime delDate;		// ��������
		private LocalDateTime upDate;		// ��������
		private String regDate;				// �������
		private String userImg;				// ����� �̹���
		private String userId;				// ����� ID
		
		private int commentCnt;			// ���� ����
		
		
		// �Խñ� ��ȸ ������ (�ε� ��)
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
		
		private int commentSeq;				// ��� �ε���
		private String commentTxt;			// ��� ����
		private String board_seq;			// �Խñ� ��ȣ
		private int depth;					// ����
		private int groupNum;				// ��� �׷�
		private String regDate;				// �������
		private String userId;				// ����� ID
		private String userImg;				// ����� �̹���
		
		// �Խñ� ��ȸ ������ (���� ��ȸ ��)
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
