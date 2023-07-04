package jpa.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Table(name="MENU")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Menu {
	
	@Id
	private int menuSeq;		// �޴� �Ϸù�ȣ
	
	@NonNull
	private int menuTop;		// �����޴� �Ϸù�ȣ
	
	@NonNull
	private String menuName; 	// �޴� ��
	
	@Builder
	public Menu(int menuSeq, int menuTop, String menuName) {
		this.menuSeq = menuSeq;
		this.menuTop = menuTop;
		this.menuName = menuName;
	}
}
