package menu.utils;

import java.util.HashSet;
import java.util.List;

public class Validator {

    private static final String INVALID_COACH_COUNT = "[ERROR] 코치는 2명에서 5명까지 입력이 가능합니다.";
    private static final String DUPLICATED_NAME = "[ERROR] 중복되지 않는 이름을 입력해주세요.";
    public static void checkCoachesCount(String[] inputCoachNames) {
        if(inputCoachNames.length != new HashSet<String>(List.of(inputCoachNames)).size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME);
        }
        if (!(2 <= inputCoachNames.length && inputCoachNames.length <= 5)) {
            throw new IllegalArgumentException(INVALID_COACH_COUNT);
        }
    }
}
