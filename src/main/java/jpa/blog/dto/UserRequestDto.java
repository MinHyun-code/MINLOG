package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {
	
	private String userId; 			// 아이디 - PK
	private String userPw;	 		// 비밀번호
	private String userName; 		// 이름
	private int status; 			// 상태 값
	private LocalDateTime regDate; 	// 생성일
	private LocalDateTime delDate;	// 삭제일
	
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
