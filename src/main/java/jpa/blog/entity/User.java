package jpa.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Entity
public class User {

	@Id
	private String userId; 			// ���̵� - PK

	@NonNull
	private String userPw;	 		// ��й�ȣ
	
	@NonNull
	private String userName; 		// �̸�
	
	@NonNull
	private int status; 			// ���� ��
	
	private String userIntro;		// �ڱ�Ұ�
	
	@NonNull
	private LocalDateTime regDate; 	// ������
	
	private LocalDateTime delDate;	// ������
	
	private Role role;
	
    @Builder
    public User(String userId, String userPw, String userName, String userIntro, int status, LocalDateTime regDate, LocalDateTime delDate, Role role) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userIntro = userIntro;
        this.status = status;
        this.regDate = regDate;
        this.delDate = delDate;
        this.role = role;
    }
}
