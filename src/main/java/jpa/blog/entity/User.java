package jpa.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import jpa.blog.security.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

	@Id
	private String userId; 			// ���̵� - PK
	private String userPw;	 		// ��й�ȣ
	private String userName; 		// �̸�
	private int status; 			// ���� ��
	private LocalDateTime regDate; 	// ������
	private LocalDateTime delDate;	// ������
	private Role role;
	
    @Builder
    public User(String userId, String userPw, String userName, int status, LocalDateTime regDate, LocalDateTime delDate, Role role) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.status = status;
        this.regDate = regDate;
        this.delDate = delDate;
        this.role = role;
    }
}
