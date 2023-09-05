package jpa.blog.security;

import java.io.Serializable;

import jpa.blog.entity.User;
import lombok.Getter;

@Getter
public class UserSessionDto implements Serializable {
	private String userId;
	private String userPw;
	private String userName;
	private String userImg;
	private Role role;
	
	/* Entity -> Dto */
	public UserSessionDto(User user) {
		this.userId = user.getUserId();
		this.userPw = user.getUserPw();
		this.userName = user.getUserName();
		this.userImg = user.getUserImg();
		this.role = user.getRole();
	}
}