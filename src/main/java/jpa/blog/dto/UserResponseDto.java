package jpa.blog.dto;

import java.time.LocalDateTime;

import jpa.blog.entity.User;
import lombok.Data;

public class UserResponseDto {
	
	@Data
	public static class userSimpleInfo{
		private String userId; 			// 아이디 - PK
		private String userPw;	 		// 비밀번호
		private String userName; 		// 이름
		private String userIntro;		// 자기소개
		private String userImg; 		// 이미지
		private int status; 			// 상태 값
		private LocalDateTime regDate; 	// 생성일
		private LocalDateTime delDate;	// 삭제일
		
		public userSimpleInfo(User entity) {
			this.userId = entity.getUserId();
			this.userName = entity.getUserName();
			this.userImg = entity.getUserImg();
			this.userIntro = entity.getUserIntro();
		}
	}
}