package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {
	
	private String userId; 			// ���̵� - PK
	private String userPw;	 		// ��й�ȣ
	private String userName; 		// �̸�
	private int status; 			// ���� ��
	private LocalDateTime regDate; 	// ������
	private LocalDateTime delDate;	// ������
	
	public User toEntity() {
		return User.builder()
				.userId(userId)
				.userPw(userPw)
				.userName(userName)
				.status(status)
				.regDate(regDate)
				.delDate(delDate)
				.build();
	}
}
