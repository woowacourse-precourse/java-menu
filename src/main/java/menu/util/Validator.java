package menu.util;

import java.util.Arrays;
import java.util.List;

public class Validator {

    private static final int MINIMUM_LENGTH = 2;
    private static final int MAXIMUN_LENGTH = 4;

    private static final int MINIMUM_NUMBER = 2;
    private static final int MAXIMUN_NUMBER = 5;

    public static void validateCoach(String coachesByRest) {
        List<String> coaches = Arrays.asList(coachesByRest.split(",",-1));
        coaches.stream()
                .forEach(coachName -> validateCoachName(coachName));
        validateCoachNumber(coaches);
    }

    private static void validateCoachName(String name) {
        if (name.equals("") || name == null) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 공백일 수 없습니다.");
        }
        if (!(name.length() >= MINIMUM_LENGTH && name.length() <= MAXIMUN_LENGTH)) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자이여야 합니다.");
        }
    }

    private static void validateCoachNumber(List<String> coaches) {
        if (!(coaches.size() >= MINIMUM_NUMBER && coaches.size() <= MAXIMUN_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명까지 등록할 수 있습니다.");
        }
    }
}
