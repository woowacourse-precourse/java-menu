package menu.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CoachNameParser {
    private static final String DELIMITER = ",";

    private static void validate(String name) {
        if (name.length() > 4 || name.length() < 2) {
            throw new IllegalArgumentException("코치님의 이름은 2에서 4글자 사이입니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이 아니어야 합니다.");
        }
    }

    private static void validateNames(List<String> names) {
        int coachCount = names.size();
        if (new HashSet<>(names).size() != coachCount) {
            throw new IllegalArgumentException("코치의 이름이 중복되었습니다");
        }
        if (coachCount > 5 || coachCount < 2) {
            throw new IllegalArgumentException("2명에서 5명 사이로 입력해주세요");
        }
    }

    public static List<String> parseName(String input) {
        List<String> names = new ArrayList<>();
        for (String name: input.split(DELIMITER)) {
            validate(name);
            names.add(name);
        }
        validateNames(names);

        return names;
    }
}
