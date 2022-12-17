package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Coaches {
    private static final String SPACE = " ";
    private static final String NONE = "";
    private static final String COMMA = ",";
    private static final String REGEX_KOREAN = "^[ㄱ-ㅎ가-힣,]*$";

    private final List<Coach> coaches;

    public Coaches(final List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches create(final String input) {
        validateKorean(input);

        final String[] coachesName = input.trim().replaceAll(SPACE, NONE).split(COMMA);
        validateCoachName(coachesName);

        return createCoaches(coachesName);
    }

    private static void validateKorean(final String input) {
        if (!Pattern.matches(REGEX_KOREAN, input)) {
            throw new IllegalArgumentException("코치 이름은 한글만 입력할 수 있습니다.");
        }
    }

    private static void validateCoachName(final String[] coachesName) {
        validateNameLength(coachesName);
        validateMemberSize(coachesName);
    }

    private static void validateNameLength(final String[] coachesName) {
        for (String name : coachesName) {
            if (name.length() > 4 || name.length() < 2) {
                throw new IllegalArgumentException("코치 이름은 2글자에서 4글자 사이어야 합니다.");
            }
        }
    }

    private static void validateMemberSize(final String[] coachesName) {
        if (coachesName.length > 5 || coachesName.length < 2) {
            throw new IllegalArgumentException("코치는 2명에서 5명 사이로 입력해주세요.");
        }
    }

    private static Coaches createCoaches(final String[] coachesName) {
        final List<Coach> coaches = Arrays.stream(coachesName)
                .map(Coach::new)
                .collect(Collectors.toList());

        return new Coaches(coaches);
    }
}
