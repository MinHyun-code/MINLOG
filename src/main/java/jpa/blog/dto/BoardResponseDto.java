package jpa.blog.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jpa.blog.common.CommonUtil;
import jpa.blog.entity.Board;
import lombok.Data;

public class BoardResponseDto {
	
	@Data
	public static class BoardList {
		private String boardSeq;		// �Ϸù�ȣ
		private String title;			// ����
		private String userId;			// �����
		private String regDate;  		// �������
		private String thumbnail;		// ����� �̹���
		private String thumbnailTxt;	// ����� �ؽ�Ʈ
		private int commentCnt;			// ��� ����
		private int likeCnt;			// ���� ����
		
		// ����ȭ�� �Խñ� ����Ʈ
		public BoardList(jpa.blog.repository.BoardList entity) {
			this.boardSeq = entity.getBoardSeq();
			this.title = entity.getTitle();
			this.userId = entity.getUserId();
			this.regDate = CommonUtil.boardDayDiff(entity.getRegDate());
			this.thumbnail = entity.getThumbnail();
			this.thumbnailTxt = entity.getThumbnailTxt();
			if(entity.getCommentCnt() > 0) {
				this.commentCnt = entity.getCommentCnt();
			}
			if(entity.getLikeCnt() > 0) {
				this.likeCnt = entity.getLikeCnt();
			}
		}
	}

	@Data
	public static class BoardDetail {
		private String boardSeq;		// �Ϸù�ȣ
		private String title;			// ����
		private String content;			// ����
		private int menuSeq;			// �޴�
		private String userId;			// ����� ID
		private String userName;		// ����� �̸�
		private String userImg;			// ����� ����
		private String userIntro;		// ����� �Ұ�
		private String regDate;  		// �������
		private String upDate; 			// ��������
		private String thumbnail;		// ����� �̹���
		private String thumbnailTxt;	// ����� �ؽ�Ʈ
		private String openYn;			// ��������
		
		// �Խñ� ��
		public BoardDetail(Board entity) {
			this.boardSeq = entity.getBoardSeq();
			this.title = entity.getTitle();
			this.content = entity.getContent();
			this.menuSeq = entity.getMenuSeq();
			this.userId = entity.getUserId().getUserId();
			this.userName = entity.getUserId().getUserName();
			this.userImg = entity.getUserId().getUserImg();
			this.userIntro = entity.getUserId().getUserIntro();
			this.regDate = CommonUtil.boardDayDiff(entity.getRegDate());
			this.thumbnail = entity.getThumbnail();
			this.thumbnailTxt = entity.getThumbnailTxt();
			this.openYn = entity.getOpenYn();
		}
	}

}
