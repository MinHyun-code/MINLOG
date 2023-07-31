package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.User;
import lombok.Data;

public class UserResponseDto {
	
	@Data
	public static class userSimpleInfo{
		private String userId; 			// ���̵� - PK
		private String userPw;	 		// ��й�ȣ
		private String userName; 		// �̸�
		private String userIntro;		// �ڱ�Ұ�
		private String userImg; 		// �̹���
		private int status; 			// ���� ��
		private LocalDateTime regDate; 	// ������
		private LocalDateTime delDate;	// ������
		
		public userSimpleInfo(User entity) {
			this.userId = entity.getUserId();
			this.userName = entity.getUserName();
			this.userImg = entity.getUserImg();
			this.userIntro = entity.getUserIntro();
		}
	}
}
