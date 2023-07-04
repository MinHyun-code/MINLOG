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
	private int menuSeq;		// 메뉴 일련번호
	
	@NonNull
	private int menuTop;		// 상위메뉴 일련번호
	
	@NonNull
	private String menuName; 	// 메뉴 명
	
	@Builder
	public Menu(int menuSeq, int menuTop, String menuName) {
		this.menuSeq = menuSeq;
		this.menuTop = menuTop;
		this.menuName = menuName;
	}
}
