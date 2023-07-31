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
	private String userId; 			// ���̵� - PK

	@Column(nullable = false)
	private String userPw;	 		// ��й�ȣ
	
	@Column(nullable = false)
	private String userName; 		// �̸�

	private String userImg; 		// �̹���
	
	@Column(nullable = false)
	private int status; 			// ���� ��
	
	private String userIntro;		// �ڱ�Ұ�
	
	@Column(nullable = false)
	private LocalDateTime regDate; 	// ������
	
	private LocalDateTime delDate;	// ������
	
	private Role role;
	
	// N+1 ������ �����ϱ� ���� Set ���
	@OneToMany(mappedBy = "userId")
	private Set<Board> board = new LinkedHashSet<>();
	
	// N+1 ������ �����ϱ� ���� Set ���
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
