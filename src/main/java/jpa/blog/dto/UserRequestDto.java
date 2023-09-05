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
		private String userId; 			// 아이디 - PK
		private String userEmail;		// 이메일
		private String userPw;	 		// 비밀번호
		private String userName; 		// 이름
		private String userImg;			// 이미지
		private String userIntro;		// 자기소개
		private int status; 			// 상태 값
		private LocalDateTime regDate; 	// 생성일
		private LocalDateTime delDate;	// 삭제일
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
