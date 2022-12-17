package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	List<String> menus;

	public Menu(List<String> menus) {
		this.menus = menus;
	}

	public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}
}
