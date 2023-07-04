package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.User;
import lombok.Data;

@Data
public class UserResponseDto {
	
	private String userId; 			// ���̵� - PK
	private String userPw;	 		// ��й�ȣ
	private String userName; 		// �̸�
	private String userIntro;		// �ڱ�Ұ�
	private int status; 			// ���� ��
	private LocalDateTime regDate; 	// ������
	private LocalDateTime delDate;	// ������
	
	public UserResponseDto(User entity) {
		this.userId = entity.getUserId();
		this.userPw = entity.getUserPw();
		this.userName = entity.getUserName();
		this.userIntro = entity.getUserIntro();
		this.status = entity.getStatus();
		this.regDate = entity.getRegDate();
		this.delDate = entity.getDelDate();
	}
}
