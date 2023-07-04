package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.User;
import lombok.Data;

@Data
public class UserResponseDto {
	
	private String userId; 			// 아이디 - PK
	private String userPw;	 		// 비밀번호
	private String userName; 		// 이름
	private String userIntro;		// 자기소개
	private int status; 			// 상태 값
	private LocalDateTime regDate; 	// 생성일
	private LocalDateTime delDate;	// 삭제일
	
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
