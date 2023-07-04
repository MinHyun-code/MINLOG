package jpa.blog.dto;

import javax.persistence.Id;

import jpa.blog.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuRequestDto {

	@Id
	private int menuSeq;		// 메뉴 일련번호
	private int menuTop;		// 상위메뉴 일련번호
	private String menuName; 	// 메뉴 명
	
	public Menu toEntity() {
		Menu menu = Menu.builder()
				.menuSeq(menuSeq)
				.menuTop(menuTop)
				.menuName(menuName)
				.build();
		return menu;
	}
}
