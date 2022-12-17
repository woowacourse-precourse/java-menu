package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String NAME_SEPARATOR = ",";

    public List<String> readCoachNames() {
        String input = readInput();
        return splitComma(input);
    }

    public List<String> readDislikeMenu() {
        String input = readInput();
        return splitComma(input);
    }

    private List<String> splitComma(String input) {
        return Arrays.asList(input.split(NAME_SEPARATOR));
    }

    private String readInput() {
        return Console.readLine();
    }
}
