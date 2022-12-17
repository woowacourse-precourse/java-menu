package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.repository.MenuRepository;

public class InputView {
	private static final int MIN_COACH = 2;
	private static final int MAX_COACH = 5;

	private static final String coachNameRequestMsg = "코치의 이름을 입력해 주세요. (, 로 구분)";
	private static final String unableMenuRequestSuffix = "(이)가 못 먹는 메뉴를 입력해 주세요.";

	public static List<Coach> readCoachNames() {
		System.out.println(coachNameRequestMsg);
		while(true) {
			try {
				String names = Console.readLine();
				validateCoaches(names);
				return Arrays.asList(names.split(",")).stream()
					.map(name -> new Coach(name))
					.collect(Collectors.toList());
			} catch (IllegalArgumentException e) {
				System.out.println();
			}
		}
	}

	private static void validateCoaches (String names) {
		if (names.split(",").length < MIN_COACH) {
			throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
		}
		if (names.split(",").length > MIN_COACH) {
			throw new IllegalArgumentException("[ERROR] 코치는 최대 5명 까지 입력해야 합니다.");
		}
	}

	public static List<Menu> readUnableMenus(Coach coach) {
		System.out.println(coach.getName() + unableMenuRequestSuffix);
		while(true) {
			try {
				String unableMenus = Console.readLine();
				return menuStringToMenus(unableMenus);
			} catch (IllegalArgumentException e) {
				System.out.println();
			}
		}
	}

	private static List<Menu> menuStringToMenus(String unableMenus) {
		validateMenuNumber(unableMenus);
		return Arrays.asList(unableMenus.split(",")).stream()
			.map(menuName -> MenuRepository.getMenu(menuName))
			.collect(Collectors.toList());
	}

	private static void validateMenuNumber(String unableMenus) {
		String[] split = unableMenus.split(",");
		if (split.length > 2) {
			throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최대 2개까지 가능합니다.");
		}
	}
}
