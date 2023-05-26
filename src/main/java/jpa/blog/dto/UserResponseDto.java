package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
	
	private String userId; 			// ���̵� - PK
	private String userPw;	 		// ��й�ȣ
	private String userName; 		// �̸�
	private int status; 			// ���� ��
	private LocalDateTime regDate; 	// ������
	private LocalDateTime delDate;	// ������
	
	public UserResponseDto(User entity) {
		this.userId = entity.getUserId();
		this.userPw = entity.getUserPw();
		this.userName = entity.getUserName();
		this.status = entity.getStatus();
		this.regDate = entity.getRegDate();
		this.delDate = entity.getDelDate();
	}
}
