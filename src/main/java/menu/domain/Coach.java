package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utils.ErrorMessage;

public class Coach {

	private final String name;
	private List<String> avoidMenu;

	public Coach(String name) {
		validateNameLength(name);
		this.name = name;
		this.avoidMenu = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addAvoidMenu(List<String> avoidMenu) {
		this.avoidMenu.addAll(avoidMenu);
	}

	public String getWeeklyMenu(List<Category> recommendation) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format(" %s ", getName()));
		System.out.println(recommendation);
		for (Category category : recommendation) {
			Set<String> intersections = new HashSet<>(category.getMenu());
			intersections.removeAll(new HashSet<>(avoidMenu));
			stringBuilder.append(String.format("|  %s  ", Randoms.shuffle(List.copyOf(intersections)).get(0)));
		}
		return stringBuilder.toString();

	}

	private void validateNameLength(String name) {
		if (2 > name.length() || name.length() > 4) {
			throw new IllegalArgumentException(ErrorMessage.LENGTH.getMessage());
		}
	}

}
