package jpa.blog.entity;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import jpa.blog.dto.BoardRequestDto;
import jpa.blog.dto.UserRequestDto;
import jpa.blog.security.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Table(name="user")
@DynamicUpdate 	// 변경한 필드만 대응
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="user")
public class User {

	@Id	
	@Column(name = "user_id")
	@Size(max = 50)
	private String userId; 			// 아이디 - PK (이메일)

	@Column(nullable = false)
	@Size(max = 15)
	private String userServeId; 	// 보여지는 ID
	
	@Column(nullable = false)
	private String userPw;	 		// 비밀번호
	
	@Column(nullable = false)
	@Size(max = 30)
	private String userName; 		// 이름

	private String userImg; 		// 이미지
	
	@Column(nullable = false)
	private int status; 			// 상태 값

	@Size(max = 100)
	private String userIntro;		// 자기소개
	
	@Column(nullable = false)
	private LocalDateTime regDate; 	// 생성일
	
	private LocalDateTime modDate; 	// 변경일
	
	private LocalDateTime delDate;	// 삭제일
	
	private Role role;
	
	// N+1 문제를 방지하기 위해 Set 사용
	@OneToMany(mappedBy = "userId")
	private Set<Board> board = new LinkedHashSet<>();
	
	// N+1 문제를 방지하기 위해 Set 사용
	@OneToMany(mappedBy = "userId")
	private Set<Comment> comment = new LinkedHashSet<>();
	
    @Builder
    public User(String userId, String userPw, String userServeId, String userName, String userImg, String userIntro, int status, LocalDateTime regDate, LocalDateTime modDate, LocalDateTime delDate, Role role) {
        this.userId = userId;
        this.userServeId = userServeId;
        this.userPw = userPw;
        this.userName = userName;
        this.userImg = userImg;
        this.userIntro = userIntro;
        this.status = status;
        this.regDate = regDate;
        this.modDate = modDate;
        this.delDate = delDate;
        this.role = role;
    }
    
    // 개인 정보 수정
 	public void changeUser(UserRequestDto.Create userDto) {
        this.userId = userDto.getUserId();
        this.userServeId = userDto.getUserServeId();
        this.userPw = userDto.getUserPw();
        this.userName = userDto.getUserName();
        this.userImg = userDto.getUserImg();
        this.userIntro = userDto.getUserIntro();
        this.status = userDto.getStatus();
        this.regDate = userDto.getRegDate();
        this.modDate = userDto.getModDate();
        this.delDate = userDto.getDelDate();
 	}
}