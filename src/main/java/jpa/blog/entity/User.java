package jpa.blog.entity;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jpa.blog.security.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Table(name="USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="USER")
public class User {

	@Id	
	@Column(name = "user_id")
	private String userId; 			// 아이디 - PK

	@Column(nullable = false)
	private String userPw;	 		// 비밀번호
	
	@Column(nullable = false)
	private String userName; 		// 이름

	private String userImg; 		// 이미지
	
	@Column(nullable = false)
	private int status; 			// 상태 값
	
	private String userIntro;		// 자기소개
	
	@Column(nullable = false)
	private LocalDateTime regDate; 	// 생성일
	
	private LocalDateTime delDate;	// 삭제일
	
	private Role role;
	
	// N+1 문제를 방지하기 위해 Set 사용
	@OneToMany(mappedBy = "userId")
	private Set<Board> board = new LinkedHashSet<>();
	
	// N+1 문제를 방지하기 위해 Set 사용
	@OneToMany(mappedBy = "userId")
	private Set<Comment> comment = new LinkedHashSet<>();
	
    @Builder
    public User(String userId, String userPw, String userName, String userImg, String userIntro, int status, LocalDateTime regDate, LocalDateTime delDate, Role role) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userImg = userImg;
        this.userIntro = userIntro;
        this.status = status;
        this.regDate = regDate;
        this.delDate = delDate;
        this.role = role;
    }
}
