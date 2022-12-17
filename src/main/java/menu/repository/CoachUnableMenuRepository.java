package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import menu.domain.Coach;
import menu.domain.Menu;

public class CoachUnableMenuRepository {

	private static Map<Coach, List<Menu>> unable = new HashMap<>();

	public static Map<Coach, List<Menu>> unable() {
		return Collections.unmodifiableMap(unable);
	}

	public static List<Menu> getUnableByCoach(Coach coach) {
		return Collections.unmodifiableList(unable.get(coach));
	}

	public static void addUnableMenuByCoach(Coach coach, Menu menu) {
		if (unable.get(coach) == null) {
			unable.put(coach, new ArrayList<>());
		}
		List<Menu> unableMenus = unable.get(coach);
		unableMenus.add(menu);
	}

	public static boolean canCoachEat(Coach coach, Menu menu) {
		if (unable.get(coach) == null) {
			return true;
		}
		return unable.get(coach).stream()
			.filter(menu1 -> menu1.equals(menu))
			.findAny().isEmpty();
	}

	public static void clear() {
		unable().clear();
	}
}
