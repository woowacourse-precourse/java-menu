package menu.service;

import menu.domain.Coaches;
import menu.domain.WeeklyMenu;

public class menu {

	private final WeeklyMenu weeklyMenu;
	private final Coaches coaches;

	public menu(Coaches coaches) {
		this.weeklyMenu = new WeeklyMenu();
		this.coaches = coaches;
	}

	public String WeeklyCategories() {
		return String.format("[ 카테고리 %s]%n", weeklyMenu.getWeeklyMenuResult());
	}

}
