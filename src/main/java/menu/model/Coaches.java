package menu.model;

import menu.utils.Serializer;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Coaches extends Serializer {
    private static final String REGEX_KOREAN = "^[ㄱ-ㅎ가-힣, ]*$";
    private static final String INPUT_KOREAN_COACH_NAME = "코치 이름은 한글만 입력할 수 있습니다.";
    private static final String NOT_RIGHT_NUMBER_OF_NAME_LENGTH = "코치 이름은 2글자에서 4글자 사이어야 합니다.";
    private static final String NOT_RIGHT_COACH_SIZE = "코치는 2명에서 5명 사이로 입력해주세요.";
    private static final int MAX_MERMBER_SIZE = 5;
    private static final int MIN_MEMBER_SIZE = 2;
    private static final int MAX_MEMBER_LENGTH = 4;
    private static final int MIN_MEMBER_LENGTH = 2;

    private final List<Coach> coaches;

    public Coaches(final List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public static Coaches create(final String input) {
        validateKorean(input);

        final String[] coachesName = serialize(input);
        validateCoachName(coachesName);

        return createCoaches(coachesName);
    }

    private static void validateKorean(final String input) {
        if (!Pattern.matches(REGEX_KOREAN, input)) {
            throw new IllegalArgumentException(INPUT_KOREAN_COACH_NAME);
        }
    }

    private static void validateCoachName(final String[] coachesName) {
        validateNameLength(coachesName);
        validateMemberSize(coachesName);
    }

    private static void validateNameLength(final String[] coachesName) {
        for (String name : coachesName) {
            if (name.length() > MAX_MEMBER_LENGTH || name.length() < MIN_MEMBER_LENGTH) {
                throw new IllegalArgumentException(NOT_RIGHT_NUMBER_OF_NAME_LENGTH);
            }
        }
    }

    private static void validateMemberSize(final String[] coachesName) {
        if (coachesName.length > MAX_MERMBER_SIZE || coachesName.length < MIN_MEMBER_SIZE) {
            throw new IllegalArgumentException(NOT_RIGHT_COACH_SIZE);
        }
    }

    private static Coaches createCoaches(final String[] coachesName) {
        final List<Coach> coaches = Arrays.stream(coachesName)
                .map(Coach::new)
                .collect(Collectors.toList());

        return new Coaches(coaches);
    }
}
