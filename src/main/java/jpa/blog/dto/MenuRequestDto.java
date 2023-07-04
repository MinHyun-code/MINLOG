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
	private int menuSeq;		// �޴� �Ϸù�ȣ
	private int menuTop;		// �����޴� �Ϸù�ȣ
	private String menuName; 	// �޴� ��
	
	public Menu toEntity() {
		Menu menu = Menu.builder()
				.menuSeq(menuSeq)
				.menuTop(menuTop)
				.menuName(menuName)
				.build();
		return menu;
	}
}
