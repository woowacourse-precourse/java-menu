package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotelMenu {
	Map<String, List<String>> totelMenus = new HashMap<>();

	public void settingTotelMenus(String categories, List<String> menus) {
		totelMenus.put(categories, menus);
	}

	public List<String> getCategoryMenu(String category) {
		return totelMenus.get(category);
	}
}
