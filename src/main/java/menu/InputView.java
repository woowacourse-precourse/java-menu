package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	RecommendException recommendException = new RecommendException();
	public List<String> readInputCoachs() {
		List<String> splitCoachs = new ArrayList<>();
		String inputCoachs = Console.readLine();
		checkinputCoachs(inputCoachs);
		splitCoachs.addAll(List.of(inputCoachs.split(",")));
		return splitCoachs;
	}

	public List<String> readNotEatFood() {
		List<String> splitFoods = new ArrayList<>();
		String inputNotEatFoods = Console.readLine();
		splitFoods.addAll(Arrays.asList(inputNotEatFoods.split(",")));
		return splitFoods;
	}

	public void checkinputCoachs(String inputCoachs) {
		String[] split = inputCoachs.split(",");
		recommendException.checkCoachsSize(split.length);
		recommendException.checkCoachsNameSize(split);
		recommendException.checkMissMatch(split);
	}
}
