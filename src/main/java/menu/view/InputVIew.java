package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
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

    private static final String DELIMITER = ",";

    public static List<String> readCoachNames() {
        System.out.println(Message.REQUEST_COACH_NAME.explanation);
        String input = readInputAddOneLineBreak(Console::readLine);
        return Arrays.asList(input.split(DELIMITER));
    }

    public static List<String> readCannotEatMenus(Coach coach) {
        System.out.printf(Message.REQUEST_CANNOT_EAT_MENUS.explanation, coach.getName());
        System.out.println();
        String input = readInputAddOneLineBreak(Console::readLine);
        return Arrays.asList(input.split(DELIMITER));
    }

    public static <T> T readInputAddOneLineBreak(Supplier<T> inputReader) {
        T input = inputReader.get();
        System.out.println();
        return input;
    }
}
