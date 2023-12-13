package jpa.blog.dto;

import javax.persistence.Id;

import jpa.blog.entity.Menu;
import lombok.Data;

@Data
public class MenuResponseDto {
	
	@Id
	private int menuSeq;		// 메뉴 일련번호
	private int menuTop;		// 상위메뉴 일련번호
	private String menuName; 	// 메뉴 명
	
	
	public MenuResponseDto(Menu entity) {
		this.menuSeq = entity.getMenuSeq();
		this.menuTop = entity.getMenuTop();
		this.menuName = entity.getMenuName();
	}
}