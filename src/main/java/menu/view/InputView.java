package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String NAME_SEPARATOR = ",";
    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (%s 로 구분)\n";
    private static final String INPUT_DISLIKE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public List<String> readCoachNames() {
        System.out.printf(INPUT_COACH_NAME, NAME_SEPARATOR);
        String input = readInput();
        return splitComma(input);
    }

    public List<String> readDislikeMenu(String coachName) {
        System.out.printf(INPUT_DISLIKE_MENU, coachName);
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
