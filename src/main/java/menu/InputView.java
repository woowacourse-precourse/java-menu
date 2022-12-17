package menu;

import java.util.ArrayList;
import java.util.Arrays;
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
		String inputNotEatFoods = Console.readLine();
		splitFoods.addAll(Arrays.asList(inputNotEatFoods.split(",")));
		return splitFoods;
	}
}
