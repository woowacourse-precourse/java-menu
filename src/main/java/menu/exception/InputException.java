package menu.exception;

public class InputException {
    private final static String CREW_LENGTH_ERROR_MESSAGE = "코치는 최소 2명 이상 입력해야 합니다.";
    private final static String CREW_NAME_SIZE_ERROR_MESSAGE = "이름은 최소 2글자, 최대 4글자입니다.";
    private final static int MIN_CREW_SIZE = 2;
    private final static int MAX_CREW_SIZE = 5;
    private final static int MAX_CREW_NAME_SIZE = 4;
    private final static int MIN_CREW_NAME_SIZE = 2;

    public void validateCoaches(String input) {
        validateCoachSize(input);
        validateCoachName(input);
    }

    private void validateCoachSize(String input) {
        String[] coaches = input.split(",");
        if (!(coaches.length >= MIN_CREW_SIZE && coaches.length <= MAX_CREW_SIZE)) {
            throw new IllegalArgumentException(CREW_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateCoachName(String input) {
        String[] coaches = input.split(",");
        for (String crew : coaches) {
            if (!(crew.length() >= MIN_CREW_NAME_SIZE && crew.length() <= MAX_CREW_NAME_SIZE)) {
                throw new IllegalArgumentException(CREW_NAME_SIZE_ERROR_MESSAGE);
            }
        }
    }
}
