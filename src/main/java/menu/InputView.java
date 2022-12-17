package menu;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public List<String> readinputCoachs() {
		List<String> splitCoachs = new ArrayList<>();
		String inputCoachs = Console.readLine();
		splitCoachs.addAll(List.of(inputCoachs.split(",")));
		return splitCoachs;
	}
}
