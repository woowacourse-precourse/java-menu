package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_DELIMITER = ",";

    public static List<String> readCoachName() {
        String input = Console.readLine();
        validateCoachInputFormat(input);
        return Arrays.stream(input.split(INPUT_DELIMITER))
                .collect(Collectors.toList());
    }

    private static void validateCoachInputFormat(String input) {
        String[] names = input.split(INPUT_DELIMITER, -1);
        if (names.length < 2 || names.length > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 할 수 있습니다.");
        }
    }
}