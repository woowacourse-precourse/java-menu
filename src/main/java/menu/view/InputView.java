package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.utils.ErrorMessages;

public class InputView {

    private static final String INPUT_DELIMITER = ",";

    private static final int MAX_FOODS = 2;

    private static final int MIN_COACH_SIZE = 2;
    private static final int MAX_COACH_SIZE = 5;

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    public List<String> readCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        printNewLine();
        List<String> names = toList(input);
        validateCoachNames(names);
        return names;
    }

    private void printNewLine() {
        System.out.println();
    }

    private List<String> toList(String input) {
        return Arrays.stream(input.split(INPUT_DELIMITER))
            .collect(Collectors.toList());
    }

    private void validateCoachNames(List<String> names) {
        if (names.size() < MIN_COACH_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.TOO_MIN_COACH);
        }
        if (names.size() > MAX_COACH_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.TOO_MANY_COACH);
        }
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.TOO_MIN_NAME);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.TOO_BIG_NAME);
        }
    }

    public List<String> readNotEatFoods(String coachName) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
        String input = Console.readLine();
        printNewLine();
        List<String> foods = toList(input);
        validateNotEatFoods(foods);
        return foods;
    }

    private void validateNotEatFoods(List<String> foods) {
        if (foods.size() > MAX_FOODS) {
            throw new IllegalArgumentException(ErrorMessages.OVER_MAX_FOOD);
        }
    }
}
