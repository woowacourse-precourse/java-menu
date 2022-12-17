package menu.view;

public class InputValidator {

    private static final int MINIMUM_COACH_NAME_LENGTH = 2;
    private static final int MAXIMUM_COACH_NAME_LENGTH = 4;
    private static final String INVALID_COACH_NAME_LENGTH_MESSAGE = "코치 이름은 2글자 이상 4글자 이하입니다.";

    public void validateCoachName(String coachName) {
        if (coachName.length() < MINIMUM_COACH_NAME_LENGTH || coachName.length() > MAXIMUM_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_LENGTH_MESSAGE);
        }
    }
}
