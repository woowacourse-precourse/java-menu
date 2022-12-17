package menu.exception;

public class CoachValidator {
    private static final String EMPTY_ERROR_MESSAGE = "[ERROR] 값이 입력되지 않았습니다.";
    private static final String NOT_FORMAT_ERROR_MESSAGE = "[ERROR] 형식이 올바르지 않습니다. (,로 구분)";
    private static final String NUMBER_OF_COACH_ERROR_MESSAGE = "[ERROR] 코치는 2명 ~ 5명을 입력해야 합니다.";
    private static final String NAME_DIGITS_ERROR_MESSAGE = "[ERROR] 각 코치의 이름 자릿수는 2글자 ~ 4글자여야 합니다.";

    private static final String COMMA = ",";
    private static final int MIN_NUMBER_OF_COACH = 2;
    private static final int MAX_NUMBER_OF_COACH = 5;
    private static final int MIN_NAME_DIGITS = 2;
    private static final int MAX_NAME_DIGITS = 4;

    public static void validate(String source) {
        validateEmptyInput(source);
        validateFormat(source);
        validateNumberOfCoach(source);
        validateNameDigits(source);
    }

    public static void validateEmptyInput(String source) {
        if (source.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    public static void validateFormat(String source) {
        if (!source.contains(COMMA)) {
            throw new IllegalArgumentException(NOT_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateNumberOfCoach(String source) {
        String[] sourceSplitByComma = source.split(COMMA);
        if (sourceSplitByComma.length < MIN_NUMBER_OF_COACH || sourceSplitByComma.length > MAX_NUMBER_OF_COACH) {
            throw new IllegalArgumentException(NUMBER_OF_COACH_ERROR_MESSAGE);
        }
    }

    public static void validateNameDigits(String source) {
        String[] sourceSplitByComma = source.split(COMMA);

        for (String coachName : sourceSplitByComma) {
            if (coachName.length() < MIN_NAME_DIGITS || coachName.length() > MAX_NAME_DIGITS) {
                throw new IllegalArgumentException(NAME_DIGITS_ERROR_MESSAGE);
            }
        }
    }
}
