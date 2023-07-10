package jpa.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import jpa.blog.security.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Table(name="BOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DynamicUpdate	// ������ �ʵ常 ����
public class Board {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int boardSeq;			// �Ϸù�ȣ
	
//	@NonNull
	private String title;			// ����
	
	@Column(columnDefinition = "TEXT")
	private String content;			// ����
	
	private int menuSeq;			// �޴�
	
//	@NonNull
	private String regUserId;		// �����
	
//	@NonNull
	private LocalDateTime regDate;  // �������
	
	private LocalDateTime upDate; 	// ��������
	
	private String delYn;			// ��������
	
	private LocalDateTime delDate; 	// ��������
	
	@NonNull
	private String openYn;			// ��������
	
	
	@Builder
	public Board(int boardSeq, String title, String content, int menuSeq, String regUserId, LocalDateTime regDate, LocalDateTime upDate, String delYn, LocalDateTime delDate, String openYn) {
		this.boardSeq = boardSeq;
		this.title = title;
		this.content = content;
		this.menuSeq = menuSeq;
		this.regUserId = regUserId;
		this.regDate = regDate;
		this.upDate = upDate;
		this.delYn = delYn;
		this.delDate = delDate;
		this.openYn = openYn;
	}
}
