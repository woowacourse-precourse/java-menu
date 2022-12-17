package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public List<String > inputCoaches(){
		String input = Console.readLine();
		String[] names = input.split(",");
		isNameValidate();
		return Stream.of(names)
			.collect(Collectors.toList());
	}
}
