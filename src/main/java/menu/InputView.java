package menu;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public List<String> readInputCoachs() {
		List<String> splitCoachs = new ArrayList<>();
		String inputCoachs = Console.readLine();
		splitCoachs.addAll(List.of(inputCoachs.split(",")));
		return splitCoachs;
	}

	public List<String> readNotEatFood() {
		List<String> splitFoods = new ArrayList<>();
		String inputFoods = Console.readLine();
		splitFoods.addAll(List.of(inputFoods.split(",")));
		return splitFoods;
	}
}
