package menu.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String DELIMITE_STRING = ",";

    public List<String> readCoachName() {
        return parseWithDelimiter(Console.readLine());
    }

    public List<String> readCoachNotEat() {
        return parseWithDelimiter(Console.readLine());
    }

    private List<String> parseWithDelimiter(String input) {
        return List.of(input.split(DELIMITE_STRING));
    }
}
