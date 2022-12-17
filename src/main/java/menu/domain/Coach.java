package menu.domain;

import java.util.ArrayList;
import java.util.List;

import menu.utils.ErrorMessage;

public class Coach {

	private final String name;
	private final AvoidMenu avoidMenu;

	public Coach(String name) {
		validateNameLength(name);
		this.name = name;
		this.avoidMenu = new AvoidMenu();
	}

	private void validateNameLength(String name) {
		if (2 > name.length() || name.length() > 4) {
			throw new IllegalArgumentException(ErrorMessage.LENGTH.getMessage());
		}
	}

	public String getName() {
		return name;
	}

	public List<String> getAvoidMenu() {
		return avoidMenu.getAvoidMenu();
	}

	public void addAvoidMenu(String menu) {
		avoidMenu.addAvoidMenu(menu);
	}
	
	
}
