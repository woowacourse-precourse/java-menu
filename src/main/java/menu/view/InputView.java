package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static class InstanceHolder {
        private static final InputView INSTANCE = new InputView();
    }

    private static final String DELIMITER = ",";

    private InputView(){}

    public static InputView getInstance() {
        return InputView.InstanceHolder.INSTANCE;
    }

    public List<String> readStringList() {
        String input = Console.readLine().trim();
        return parseInput(input);
    }

    private List<String> parseInput(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
