package menu.domain;

import java.util.ArrayList;
import java.util.List;

import menu.utils.ErrorMessage;

public class AvoidMenu {

	private final List<String> avoidMenu;

	public AvoidMenu() {
		this.avoidMenu = new ArrayList<>();
	}

	public List<String> getAvoidMenu() {
		return avoidMenu;
	}

	public void addAvoidMenu(String menu) {
		List<String> avoidMenus = validateNumberOfAvoidMenu(menu);
		avoidMenu.addAll(avoidMenus);
	}

	private List<String> validateNumberOfAvoidMenu(String menu) {
		String[] avoidMenus = menu.split(",");
		if (avoidMenus.length > 2) {
			throw new IllegalArgumentException(ErrorMessage.AVOID_MENU.getMessage());
		}
		return new ArrayList<>(List.of(avoidMenus));
	}
}
