package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.User;
import jpa.blog.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
	
	private String userId; 			// 아이디 - PK
	private String userPw;	 		// 비밀번호
	private String userName; 		// 이름
	private String userIntro;		// 자기소개
	private int status; 			// 상태 값
	private LocalDateTime regDate; 	// 생성일
	private LocalDateTime delDate;	// 삭제일
	private Role role;
	
	/* DTO -> Entity */
	public User toEntity() {
		User user = User.builder()
			.userId(userId)
			.userPw(userPw)
			.userName(userName)
			.userIntro(userIntro)
			.status(status)
			.regDate(regDate)
			.delDate(delDate)
			.role(role.USER)
			.build();
	return user;
	}
}
