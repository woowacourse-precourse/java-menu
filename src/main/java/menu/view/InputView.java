package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputView {
    private static final String PROMPT_FOR_COACH_NAME_INPUT = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String PROMPT_FOR_MENU_INPUT_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";
    public static void printPromptForCoachNameInput() {
        System.out.println(PROMPT_FOR_COACH_NAME_INPUT);
    }

    public static void printPromptForMenuCannotToEatInput(String coachName) {
        System.out.printf(PROMPT_FOR_MENU_INPUT_FORMAT, coachName);
    }
    public static List<String> readCoachNameList() {
        printPromptForCoachNameInput();
        return Arrays.asList(Console.readLine().split(","));
    }



    public static List<String> readMenuCoachCannotEat(String coachName) {
        printPromptForMenuCannotToEatInput(coachName);
        String input = Console.readLine();
        if (isEmptyString(input)) {
            return Collections.emptyList();
        }
        return Arrays.asList(input.split(","));
    }

    private static boolean isEmptyString(String input) {
        return input.length() == 0;
    }
}
