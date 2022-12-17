package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//똑같은 이름 입력 검증하기
public class InputView {
    private static final String COACH_NAME_LENGTH_ERROR_MESSAGE = "코치의 이름 길이는 최소 2, 최대 4여야 합니다.";
    private static final String COACH_NUMBER_ERROR_MESSAGE = "코치는 최소 2명, 최대 5명 입력해야 합니다.";
    private static final String MENU_NUMBER_ERROR_MESSAGE = "못 먹는 메뉴 개수는 최소 0, 최대 2여야 합니다.";
    private static final String MENU_NAME_ERROR_MESSAGE = "존재하지 않는 메뉴입니다.";
    private static final String INPUT_FORMAT_ERROR_MESSAGE = "입력 형식이 올바르지 않습니다.";
    private static final String DUPLICATED_ELEMENT_ERROR_MESSAGE = "중복된 요소가 존재합니다.";

    public List<String> readCoachNames() {
        String coachNameInput = Console.readLine();
        validateInputFormat(coachNameInput);
        List<String> coaches = Arrays.asList(coachNameInput.split(","));
        validateDuplication(coaches);
        validateCoachNumber(coaches);
        for (String name : coaches) {
            validateCoachNameLength(name);
        }

        return coaches;
    }

    public List<String> readPickyEatings() {
        String pickyEatingsInput = Console.readLine();
        validateInputFormat(pickyEatingsInput);
        List<String> pickEatings = Arrays.asList(pickyEatingsInput.split(","));
        validateDuplication(pickEatings);
        validatePickyEatingsNumber(pickEatings);
        for (String pickyEating : pickEatings) {
            validatePickyEatingsName(pickyEating);
        }

        return pickEatings;
    }

    private void validateCoachNameLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateInputFormat(String input) {
        // , 구분자가 문자열들 사이에 존재하지 않을 때
        if (input.charAt(0) == ',' || input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR_MESSAGE);
        }

        //, 구분자가 연속되어 존재할 때
        if (input.contains(",,")) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR_MESSAGE);
        }
    }
    private void validateCoachNumber(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException(COACH_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validatePickyEatingsNumber(List<String> pickyEatings) {
        if (pickyEatings.size() < 0 || pickyEatings.size() > 2) {
            throw new IllegalArgumentException(MENU_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validatePickyEatingsName(String pickEating) {
        for (Category category : Category.values()) {
            if (category.getMenus().contains(pickEating)) {
                return;
            }
        }
        throw new IllegalArgumentException(MENU_NAME_ERROR_MESSAGE);
    }

    private void validateDuplication(List<String> contents) {
        Set<String> set = new HashSet<>(contents);
        if (set.size() != contents.size()) {
            throw new IllegalArgumentException(DUPLICATED_ELEMENT_ERROR_MESSAGE);
        }
    }


}
