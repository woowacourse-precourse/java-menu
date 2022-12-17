package menu.model;

import java.util.ArrayList;
import java.util.List;

public class MenuList {
	private List<Menu> menusCantEat;

	public MenuList() {
		this.menusCantEat = new ArrayList<>();
	}

	public List<Menu> getMenusCantEat() {
		return menusCantEat;
	}

}
