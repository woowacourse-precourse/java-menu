package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class InputVIew {
    private enum Message {
        REQUEST_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
        REQUEST_CANNOT_EAT_MENUS("%s(이)가 못 먹는 메뉴를 입력해 주세요.");

        private String explanation;

        Message(String explanation) {
            this.explanation = explanation;
        }
    }

    private static final int COACH_SIZE_LOWER_BOUND = 2;
    private static final int COACH_SIZE_UPPER_BOUND = 5;
    private static final int CANNOT_EAT_MENU_UPPER_BOUND = 2;
    private static final String COACH_SIZE_INVALID_MESSAGE = "코치는 최소 2명, 최대 5명까지 식사를 함께 합니다.";
    private static final String MENU_SIZE_INVALID_MESSAGE = "못먹는 메뉴는 최소 0개, 최대 2개까지 입력할 수 있습니다.";
    private static final String DELIMITER = ",";

    public static List<String> readCoachNames() throws IllegalArgumentException {
        System.out.println(Message.REQUEST_COACH_NAME.explanation);
        String input = readInputAddOneLineBreak(Console::readLine);
        List<String> coaches = Arrays.stream(input.split(DELIMITER)).map(String::trim).collect(Collectors.toList());
        validateCoachSize(coaches);
        return coaches;
    }

    public static List<String> readCannotEatMenus(Coach coach) {
        System.out.printf(Message.REQUEST_CANNOT_EAT_MENUS.explanation, coach.getName());
        System.out.println();
        String input = readInputAddOneLineBreak(Console::readLine);
        List<String> menus = Arrays.stream(input.split(DELIMITER)).map(String::trim).collect(Collectors.toList());
        validateCannotEatMenusSize(menus);
        return menus;
    }

    public static <T> T readInputAddOneLineBreak(Supplier<T> inputReader) {
        T input = inputReader.get();
        System.out.println();
        return input;
    }

    private static void validateCoachSize(List<String> coaches) {
        if (coaches.size() < COACH_SIZE_LOWER_BOUND || coaches.size() > COACH_SIZE_UPPER_BOUND) {
            throw new IllegalArgumentException(COACH_SIZE_INVALID_MESSAGE);
        }
    }

    private static void validateCannotEatMenusSize(List<String> menus) {
        if (menus.size() > CANNOT_EAT_MENU_UPPER_BOUND) {
            throw new IllegalArgumentException(MENU_SIZE_INVALID_MESSAGE);
        }
    }
}
