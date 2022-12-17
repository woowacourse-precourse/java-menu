package menu.util;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    public static final String NAME_REGEX = "^[a-zA-Zㄱ-ㅎ가-힣]+$";
    public static final int COACH_MIN_SIZE = 2;
    public static final int COACH_MAX_SIZE = 5;
    public static final int FOOD_MIN_SIZE = 0;
    public static final int FOOD_MAX_SIZE = 2;

    public static void checkCoachNames(List<String> coachNames) {
        checkPattern(coachNames);
        checkCoachSize(coachNames);
    }

    public static void checkFoodNames(List<String> foodNames) {
        checkPattern(foodNames);
        checkFoodSize(foodNames);
    }

    private static void checkPattern(List<String> names) {
        names.stream()
                .filter(name -> !Pattern.matches(NAME_REGEX, name))
                .forEach(name -> {
                    throw new IllegalArgumentException("이름 입력 값을 확인하세요");
                });
    }

    private static void checkCoachSize(List<String> names) {
        if (names.size() < COACH_MIN_SIZE || names.size() > COACH_MAX_SIZE) {
            throw new IllegalArgumentException("코치는 최소 2명 이상, 5명 이하로 입력해야 합니다.");
        }
    }

    private static void checkFoodSize(List<String> names) {
        if (names.size() < FOOD_MIN_SIZE || names.size() > FOOD_MAX_SIZE) {
            throw new IllegalArgumentException("못 먹는 음식은 최소 0개 이상, 2개 이하로 입력해야 합니다.");
        }
    }
}
