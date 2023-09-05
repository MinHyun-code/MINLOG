package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.User;
import jpa.blog.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserRequestDto {
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Create {
		private String userId; 			// ���̵� - PK
		private String userEmail;		// �̸���
		private String userPw;	 		// ��й�ȣ
		private String userName; 		// �̸�
		private String userImg;			// �̹���
		private String userIntro;		// �ڱ�Ұ�
		private int status; 			// ���� ��
		private LocalDateTime regDate; 	// ������
		private LocalDateTime delDate;	// ������
		private Role role;
		
		/* DTO -> Entity */
		public User toEntity() {
			User user = User.builder()
				.userId(userId)
				.userEmail(userEmail)
				.userPw(userPw)
				.userName(userName)
				.userImg(userImg)
				.userIntro(userIntro)
				.status(status)
				.regDate(regDate)
				.delDate(delDate)
				.role(role.USER)
				.build();
		return user;
		}
	}
}
