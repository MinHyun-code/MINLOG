package jpa.blog.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import jpa.blog.dto.BoardRequestDto;
import jpa.blog.dto.BoardResponseDto;
import jpa.blog.security.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Table(name="board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="board")
@DynamicUpdate	// ������ �ʵ常 ����
public class Board {

	@Id
	@Column(name = "board_seq")
	private String boardSeq;		// �Ϸù�ȣ
	
	@Column(columnDefinition = "varchar(100)", nullable = false)
	private String title;			// ����
	
	@Column(columnDefinition = "TEXT")
	private String content;			// ����
	
	private int menuSeq;			// �޴�
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User userId;			// ����� ID
	
	@Column(nullable = false)
	private LocalDateTime regDate;  // �������
	
	private LocalDateTime upDate; 	// ��������
	
	@Column(columnDefinition = "varchar(1) default 'N'", nullable = false)
	private String delYn;			// ��������
	
	private LocalDateTime delDate; 	// ��������
	
	private String thumbnail; 		// ����� �̹���

	@Column(columnDefinition = "varchar(150)", nullable = false)
	private String thumbnailTxt; 	// ����� �ؽ�Ʈ
	
	@Column(columnDefinition = "varchar(1)")
	private String openYn;			// ��������
	
	
	// N+1 ������ �����ϱ� ���� Set ���
	@OneToMany(mappedBy = "board")
	private Set<Comment> comment = new LinkedHashSet<>();
	
	@Builder
	public Board(String boardSeq, String title, String content, int menuSeq, User userId, LocalDateTime regDate, LocalDateTime upDate, String delYn, LocalDateTime delDate, String thumbnail, String thumbnailTxt, String openYn) {
		this.boardSeq = boardSeq;
		this.title = title;
		this.content = content;
		this.menuSeq = menuSeq;
		this.userId = userId;
		this.regDate = regDate;
		this.upDate = upDate;
		this.delYn = delYn;
		this.delDate = delDate;
		this.thumbnail = thumbnail;
		this.thumbnailTxt = thumbnailTxt;
		this.openYn = openYn;
	}
	
	// �������� ����
	public void changeDelYn(String delYn, LocalDateTime delDate) {
		this.delYn = delYn;
		this.delDate = delDate;
	}
	
	// �Խñ� ����
	public void changeBoard(BoardRequestDto.Create boardDto) {
		this.boardSeq = boardDto.getBoardSeq();
		this.title = boardDto.getTitle();
		this.content = boardDto.getContent();
		this.menuSeq = boardDto.getMenuSeq();
		this.upDate = boardDto.getUpDate();
		this.thumbnail = boardDto.getThumbnail();
		this.thumbnailTxt = boardDto.getThumbnailTxt();
		this.openYn = boardDto.getOpenYn();
	}
}
