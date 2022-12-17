package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_DELIMITER = ",";

    public static List<String> readCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        validateCoachInputFormat(input);
        return Arrays.stream(input.split(INPUT_DELIMITER))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }

    private static void validateCoachInputFormat(String input) {
        String[] names = input.split(INPUT_DELIMITER);
        if (names.length < 2 || names.length > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 할 수 있습니다.");
        }
    }

    public static List<String> readCanNotEatMenu(String name) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
        String input = Console.readLine()
                .replaceAll("(\r\n|\r|\n|\n\r)", " ");
        validEmpty(input);
        if (input.length() == 0) {
            return Collections.emptyList();
        }
        validateCanNotEatMenuFormat(input);
        return Arrays.stream(input.split(INPUT_DELIMITER))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }

    private static void validEmpty(String input) {
        String filteringInput = input.replaceAll(",", "")
                .replaceAll(" ", "");
        if (input.contains(",") && filteringInput.length() == 0) {
            throw new IllegalArgumentException("쉼표로 구분된 메뉴 이름을 입력해주세요.");
        }
    }

    private static void validateCanNotEatMenuFormat(String input) {
        long menuCount = Arrays.stream(input.split(INPUT_DELIMITER, -1))
                .map(s -> s.replaceAll(" ", ""))
                .filter(s -> s.length() > 0)
                .count();
        if (menuCount > 2) {
            throw new IllegalArgumentException("코치는 못 먹는 메뉴는 최소 0개, 최대 2개입니다.");
        }
    }
}