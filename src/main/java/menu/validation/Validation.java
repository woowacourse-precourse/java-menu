package menu.validation;

import java.util.List;

public class Validation {

    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 4;
    private static final int COACH_MIN_LENGTH = 2;
    private static final int COACH_MAX_LENGTH = 5;
    private static final int COACH_CAN_NOT_FOOD_MAX_LENGTH = 2;
    private static final String SPLIT = ",";
    private static final String ERROR_COACH_NAME_LENGTH = "[ERROR] 코치의 이름은 최소2글자 최대 4글자여야 합니다.";
    private static final String ERROR_COACH_LENGTH = "[ERROR] 코치는 최소 2명 이상 최대 5명까지 입력해야 합니다.";
    private static final String ERROR_COACH_CAN_NOT_FOOD_LENGTH = "[ERROR] 한 코치의 먹을 수 없는 음식은 최대 2개입니다.";

    // 코치의 수를 검증하는 기능
    public static void validateCoachsLength(List<String> coachName) {
        if (!(COACH_MIN_LENGTH <= coachName.size() && coachName.size() <= COACH_MAX_LENGTH)) {
            throw new IllegalArgumentException(ERROR_COACH_LENGTH);
        }
    }

    // 코치의 이름을 검증하는 기능
    public static void validateCoachNameLength(List<String> coachName) {
        boolean checkNameLength = coachName.stream()
            .allMatch(name -> NAME_MIN_LENGTH <= name.length() && name.length() <= NAME_MAX_LENGTH);
        if (!checkNameLength) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH);
        }
    }

    // 각 코치가 먹지 못하는 음식의 수 검증하는 기능
    public static void validateCoachCanNotEatFoodLength(String food) {
        if(food.split(SPLIT).length > COACH_CAN_NOT_FOOD_MAX_LENGTH) {
                throw new IllegalArgumentException(ERROR_COACH_CAN_NOT_FOOD_LENGTH);
        }
    }
}
