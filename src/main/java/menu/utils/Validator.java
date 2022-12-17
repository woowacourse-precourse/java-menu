package menu.utils;

import java.util.List;

public class Validator {
    public static void checkCoachSize(List<String> coachNames) {
        int coachSize = coachNames.size();
        if (coachSize < 2 || coachSize > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상, 최대 5명 이하여야 합니다.");
        }
    }

    public static void checkNameLength(String name) {
        int nameLength = name.length();
        if (nameLength < 2 || nameLength > 4) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자에서 최대 4글자여야 합니다.");
        }
    }
}
