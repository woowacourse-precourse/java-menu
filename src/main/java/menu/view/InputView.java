package menu.view;

import static menu.Constant.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public List<String> inputCoaches() {
		while (true) {
			try {
				String input = Console.readLine();
				String[] names = input.replace(" ", "").split(",");
				isNameLengthValidate(names);
				isArrayLengthValidate(names);
				return Stream.of(names)
					.collect(Collectors.toList());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public List<String> inputMenuCantEat() {
		while (true) {
			try {
				String input = Console.readLine();
				String[] menus = input.replace(" ", "").split(",");
				// isMenuLengthValidate();
				return Stream.of(menus)
					.collect(Collectors.toList());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void isArrayLengthValidate(String[] names) {
		if (names.length > 5 || names.length < 2) {
			throw new IllegalArgumentException(WRONG_MEMBER_MSG);
		}
	}

	private void isNameLengthValidate(String[] names) {
		for (String name : names) {
			if (name.length() > 4 || name.length() < 2) {
				throw new IllegalArgumentException(WRONG_NAME_MSG);
			}
		}
	}
}
