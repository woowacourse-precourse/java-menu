package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_CREW_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String ENTER_BANNED_FOODS = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String EMPTY_INPUT = "입력된 값이 없습니다.";
    private static final String INVALID_KOREAN_FORMAT = "한글을 올바르게 입력해주세요.";
    private static final String NON_KOREAN_CHARACTER_INCLUDED = "(.*)[^가-힇](.*)";
    private static final String COMMA = ",";

    public String[] readCrewNames() {
        final String input = inputBox(ENTER_CREW_NAMES);
        validate(input);
        return splitByRegex(input);
    }

    public String[] readBannedFoods(String crewName) {
        final String input = inputBox(crewName + ENTER_BANNED_FOODS);
        validate(input);
        return splitByRegex(input);
    }

    private String inputBox(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private void validate(String input) {
        validateBlank(input);
        validateKorean(input);
    }

    public void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }

    private void validateKorean(String input) {
        if (input.matches(NON_KOREAN_CHARACTER_INCLUDED)) {
            throw new IllegalArgumentException(INVALID_KOREAN_FORMAT);
        }
    }

    private static String[] splitByRegex(String input) {
        return input.split(COMMA);
    }
}
