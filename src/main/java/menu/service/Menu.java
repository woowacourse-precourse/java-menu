package menu.service;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.WeeklyMenu;

public class Menu {

	private final WeeklyMenu weeklyMenu;
	private final Coaches coaches;

	public Menu(Coaches coaches) {
		this.weeklyMenu = new WeeklyMenu();
		this.coaches = coaches;
	}

	public String WeeklyCategories() {
		return String.format("[ 카테고리 %s]%n", weeklyMenu.getWeeklyMenuResult());
	}

	public String getWeeklyMenu() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Coach coach : coaches.getCoaches()) {
			String menu = coach.getWeeklyMenu(weeklyMenu.getRecommendation());
			stringBuilder.append(String.format("[%s]%n", menu));
		}
		return stringBuilder.toString();
	}

}
