package menu.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;
import menu.repository.CoachRepository;
import menu.repository.MenuRecommendRepository;

public class OutputView {

	private static final String initMsg = "점심 메뉴 추천을 시작합니다.\n";
	private static final String resultMsg= "메뉴 추천 결과입니다.";
	private static final String endMsg = "추천을 완료했습니다.";

	public static void printInitMsg() {
		System.out.println(initMsg);
	}

	public static void printResult() {
		System.out.println(resultMsg);
		printDays();
		printTable();
		System.out.println();
	}

	private static void printTable() {
		printCategories();
		printCoachMenus();
	}

	private static void printDays() {
		List<Day> days = Day.getAllDays();
		List<String> dayString = days.stream()
			.map(day -> day.getDay())
			.collect(Collectors.toList());
		dayString.add(0, "구분");
		System.out.println(formatter(dayString));
	}

	private static void printCategories() {
		List<String> categories = MenuRecommendRepository.getCategories().stream()
			.map(category -> category.getName())
			.collect(Collectors.toList());
		categories.add(0, "카테고리");
		System.out.println(formatter(categories));
	}

	private static void printCoachMenus() {
		List<Coach> coaches = CoachRepository.coaches();
		for (Coach coach : coaches) {
			List<Menu> menusByCoach = MenuRecommendRepository.getMenusByCoach(coach);
			List<String> menusString = menusByCoach.stream()
				.map(menu -> menu.getName())
				.collect(Collectors.toList());
			menusString.add(0, coach.getName());
			System.out.println(formatter(menusString));
		}
	}

	private static String formatter(List<String> strings) {
		return "[ " + String.join(" | ", strings) + " ]";
	}

	public static void printEndMsg() {
		System.out.println(endMsg);
	}
}
