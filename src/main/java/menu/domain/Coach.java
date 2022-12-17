package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final Integer MIN_COACH_COUNT = 2;
    private static final Integer MAX_COACH_COUNT = 5;
    private static final Integer MIN_COACH_NAME_LENGTH = 2;
    private static final Integer MAX_COACH_NAME_LENGTH = 4;

    private static final String COACH_COUNT_OUT_OF_RANGE_MIN = "[ERROR] 코치는 최소 2명 이상 입력해야 합니다.";
    private static final String COACH_COUNT_OUT_OF_RANGE_MAX = "[ERROR] 코치는 최대 5명 이하 입력해야 합니다.";
    private static final String COACH_NAME_OUT_OF_RANGE_MIN = "[ERROR] 코치의 이름은 최소 2글자 이상 입력해야 합니다.";
    private static final String COACH_NAME_OUT_OF_RANGE_MAX = "[ERROR] 코치의 이름은 최대 4글자 이하 입력해야 합니다.";

    public List<String> makeCoaches(String names) {
        List<String> coachNames = List.of(names.split(","));
        validateCoachesLength(coachNames);
        for (int i =0; i< coachNames.size(); i++) {
            validateCoachName(coachNames.get(i));
        }
        return coachNames;
    }

    private void validateCoachesLength(List<String> testNames) {
        if (testNames.size() < MIN_COACH_COUNT) {
            throw new IllegalArgumentException(COACH_COUNT_OUT_OF_RANGE_MIN);
        }
        if (testNames.size() > MAX_COACH_COUNT) {
            throw new IllegalArgumentException(COACH_COUNT_OUT_OF_RANGE_MAX);
        }
    }

    private void validateCoachName(String name) {
        checkNameLength(name);
    }

    private void checkNameLength(String name) {
        if (name.length() < MIN_COACH_NAME_LENGTH){
            throw new IllegalArgumentException(COACH_NAME_OUT_OF_RANGE_MIN);
        }
        if (name.length() > MAX_COACH_NAME_LENGTH){
            throw new IllegalArgumentException(COACH_NAME_OUT_OF_RANGE_MAX);
        }
    }
}
