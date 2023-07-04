package jpa.blog.dto;

import javax.persistence.Id;

import jpa.blog.entity.Menu;
import lombok.Data;

@Data
public class MenuResponseDto {
	
	@Id
	private int menuSeq;		// �޴� �Ϸù�ȣ
	private int menuTop;		// �����޴� �Ϸù�ȣ
	private String menuName; 	// �޴� ��
	
	
	public MenuResponseDto(Menu entity) {
		this.menuSeq = entity.getMenuSeq();
		this.menuTop = entity.getMenuTop();
		this.menuName = entity.getMenuName();
	}
}
