package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String INPUT_DELIMITER = ",";
    public static final int MAX_FOODS = 2;

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
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명 입력해야 합니다.");
        }
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("이름은 최소 2글자, 최대 4글자여야 합니다.");
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
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개만 입력 가능합니다.");
        }
    }
}
